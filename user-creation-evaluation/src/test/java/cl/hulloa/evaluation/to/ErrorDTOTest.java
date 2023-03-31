package cl.hulloa.evaluation.to;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ErrorDTOTest {

	@Test
	void testGetCode() {
		ErrorDTO errorDTO = new ErrorDTO("code", "message");
		
		assertEquals("code",errorDTO.getCode());
		
	}

	@Test
	void testSetCode() {
		ErrorDTO errorDTO = new ErrorDTO(null, null);
		
		errorDTO.setCode("code");
		
		assertEquals("code",errorDTO.getCode());
	}

	@Test
	void testGetMessage() {
		ErrorDTO errorDTO = new ErrorDTO("code", "message");
		
		assertEquals("message",errorDTO.getMessage());
	}

	@Test
	void testSetMessage() {
	
	
	ErrorDTO errorDTO = new ErrorDTO(null, null);
	
	errorDTO.setMessage("message");
	
	assertEquals("message",errorDTO.getMessage());
	}

}
