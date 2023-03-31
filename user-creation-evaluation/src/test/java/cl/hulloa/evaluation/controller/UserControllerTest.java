package cl.hulloa.evaluation.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.hulloa.evaluation.UsuarioData;
import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.services.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	ObjectMapper objectMapper;
	

	
	@BeforeEach
	void setUp() {
		
		objectMapper = new ObjectMapper();
		
	}

	@Test
	void testCreateUsuario() throws Exception{
		
		when(userService.create(any(Usuario.class))).thenReturn(UsuarioData.getUsuarioPost());
		
		mvc.perform(post("/api/v1/user/").contentType(MediaType.APPLICATION_JSON)
				
				.content(objectMapper.writeValueAsString(UsuarioData.getUsuarioPost()
						)))
						.andExpect(status().is(201));
		
		
		verify(userService,times(1)).create(any(Usuario.class));
		
		
		
		
		
	}

}
