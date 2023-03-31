package cl.hulloa.evaluation.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DataTimeUtils {
	
	public String fechaActual() {
		
		return LocalDateTime.now().toString();
		
	}
	
	

}
