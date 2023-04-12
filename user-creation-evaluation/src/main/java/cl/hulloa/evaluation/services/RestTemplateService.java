package cl.hulloa.evaluation.services;

import cl.hulloa.evaluation.exception.CallApiException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private String serviceAUrl = "http://localhost:8083/api/v1/servicio/valor";
    private String serviceBUrl = "http://localhost:8085/api/v1/servicio/backup/valor";

    @CircuitBreaker(name = "valorCB", fallbackMethod = "fallBackFalse")
    public String traerValor(){
        String respuesta = this.restTemplate.getForObject(serviceAUrl, String.class);
        return respuesta;

    }

    public String fallback(){
        String respuesta = this.restTemplate.getForObject(serviceAUrl, String.class);
        return respuesta;
    }

    public String fallBackFalse(Throwable e){
        throw new CallApiException(e.getMessage(), "code:500");
    }



}
