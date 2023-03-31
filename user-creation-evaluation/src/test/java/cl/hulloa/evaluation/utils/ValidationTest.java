package cl.hulloa.evaluation.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidationTest {
	
	Validation validation = new Validation();
	
	

	@Test
	void testValidateEmailValido() {
		
		String email = "correo@dominio.cl";
	
		boolean val = validation.validateEmail(email);
		
		assertTrue(val);
		
				
	}
	
	@Test
	void testValidateEmailNoValido() {
		
		String email = "correo@dominio";
	
		boolean val = validation.validateEmail(email);
		
		assertFalse(val);
		
		
		
	}

	@Test
	void testValidatePasswordValido() {
		
		String password = "Asd23aad";
		
		boolean val = validation.validatePassword(password);
		
		assertTrue(val);
		
		
	}
	
	@Test
	void testValidatePasswordNoValido() {
		
		String password = "Asd2aad";
		
		boolean val = validation.validatePassword(password);
		
		assertFalse(val);
		
		
	}
}
