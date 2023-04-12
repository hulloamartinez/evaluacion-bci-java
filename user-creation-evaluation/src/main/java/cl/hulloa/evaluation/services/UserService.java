package cl.hulloa.evaluation.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.hulloa.evaluation.exception.RequestException;
import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.repositories.UserInterface;
import cl.hulloa.evaluation.utils.Validation;

@Service
public class UserService {
	
	private UserInterface userInterface;
	private Validation validation;

	private RestTemplateService restTemplateService;

	public UserService(UserInterface userInterface, Validation validation, RestTemplateService restTemplateService) {
		this.userInterface = userInterface;
		this.validation = validation;
		this.restTemplateService = restTemplateService;
	}

	public Usuario create(Usuario user) {


		if(!this.validation.validateEmail(user.getEmail())) {
			throw new RequestException("Email debe tener un formato xxxx@xxx.xx","Code:001");
		}
		if(!this.validation.validatePassword(user.getPassword())) {
			throw new RequestException( "Password no cumple con requisitos: Una Mayuscula, letras minúsculas, y dos numeros. 8 a 16 caracteres","Code:001");
		}


		user.setModified(LocalDateTime.now().toString());
		user.setCreated(LocalDateTime.now().toString());


		String respuesta = this.restTemplateService.traerValor();

		if (respuesta.equals("true")){
			user.setActive(true);
		}else user.setActive(false);



		return this.userInterface.save(user);
		
	}

	public List<Usuario> getAllUsuarios(){
		return this.userInterface.findAll();
	}

}
