package cl.hulloa.evaluation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.services.UserService;
import jakarta.validation.Valid;

import java.util.List;

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

	
	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getAllUsuario(){

		return  new ResponseEntity<>(this.userService.getAllUsuarios(),HttpStatus.ACCEPTED);

	}

}
