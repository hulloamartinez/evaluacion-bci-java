package cl.hulloa.evaluation.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.hulloa.evaluation.UsuarioData;
import cl.hulloa.evaluation.exception.RequestException;
import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.repositories.UserInterface;
import cl.hulloa.evaluation.utils.Validation;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserInterface userInterface;

	@Mock
	private Validation validation;


	@InjectMocks
	private UserService userService;
	


	@Test
	void testCreate() {
		
	

		Usuario user = UsuarioData.getUsuarioPost();

		when(userInterface.save(any(Usuario.class))).thenReturn(UsuarioData.getUsuario());
		when(validation.validateEmail(anyString())).thenReturn(true);
		when(validation.validatePassword(anyString())).thenReturn(true);

		Usuario userReturned = userService.create(user);

		assertEquals(userReturned.getEmail(), user.getEmail());
		assertNotNull(userReturned.getId());

		verify(userInterface, times(1)).save(any(Usuario.class));
		

	}

	
	@Test()
	void testExceptionRequestEmail() {

		Usuario user = UsuarioData.getUsuarioPost();

		when(validation.validateEmail(anyString())).thenReturn(false);

		RequestException exception = assertThrows(RequestException.class, () -> {

			userService.create(user);

		});

		assertEquals(RequestException.class, exception.getClass());
		assertEquals("Code:001", exception.getCode());
		
		verify(validation).validateEmail(anyString());

	}
	
	@Test()
	void testExceptionRequestPassword() {

		Usuario user = UsuarioData.getUsuarioPost();
		when(validation.validateEmail(anyString())).thenReturn(true);
		when(validation.validatePassword(anyString())).thenReturn(false);

		RequestException exception = assertThrows(RequestException.class, () -> {

			userService.create(user);

		});

		assertEquals(RequestException.class, exception.getClass());
		assertEquals("Code:001", exception.getCode());
		verify(validation).validatePassword(anyString());

	}


}
