package cl.hulloa.evaluation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	private UserService userService;
	
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}


	
	@PostMapping("/")
	public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario user){
		
		return new ResponseEntity<>(this.userService.create(user),HttpStatus.CREATED);
		
	}

	
	

}
