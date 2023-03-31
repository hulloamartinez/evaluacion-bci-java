package cl.hulloa.evaluation.services;

import org.springframework.stereotype.Service;

import cl.hulloa.evaluation.exception.RequestException;
import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.repositories.UserInterface;
import cl.hulloa.evaluation.utils.DataTimeUtils;
import cl.hulloa.evaluation.utils.Validation;

@Service
public class UserService {
	
	private UserInterface userInterface;
	private Validation validation;
	private DataTimeUtils dataTimeUtils;
	
	

	public UserService(UserInterface userInterface, Validation validation, DataTimeUtils dataTimeUtils) {
		this.userInterface = userInterface;
		this.validation = validation;
		this.dataTimeUtils = dataTimeUtils;
	}




	public Usuario create(Usuario user) {
				
		if(!this.validation.validateEmail(user.getEmail())) {
			throw new RequestException("Code:001", "Email debe tener un formato xxxx@xxx.xx");
		}
		if(!this.validation.validatePassword(user.getPassword())) {
			throw new RequestException("Code:001", "Password no cumple con requisitos: Una Mayuscula, letras minúsculas, y dos numeros. 8 a 16 caracteres");
		}
		
		user.setModified(this.dataTimeUtils.fechaActual());
		user.setCreated(this.dataTimeUtils.fechaActual());
		user.setActive(true);
		
		
		
		
		return this.userInterface.save(user);
		
	}
	

}
