package cl.hulloa.evaluation.controller;

import java.sql.SQLException;

import cl.hulloa.evaluation.exception.CallApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.hulloa.evaluation.exception.RequestException;
import cl.hulloa.evaluation.to.ErrorDTO;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class ControllerAdvice {
	

	@ExceptionHandler(RequestException.class)
	public ResponseEntity <ErrorDTO> requestExceptionHandler(RequestException ex){
		
		ErrorDTO error = new ErrorDTO(ex.getMessage(),ex.getCode());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = SQLException.class)
	public ResponseEntity <ErrorDTO> databaseExceptionHandler(SQLException ex){
		
		ErrorDTO error = new ErrorDTO(ex.getSQLState(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({RuntimeException.class, Exception.class})
	public ResponseEntity <ErrorDTO> databaseExceptionHandler(Exception ex){
		
		ErrorDTO error = new ErrorDTO(ex.getClass().toString(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceAccessException.class)
		public ResponseEntity <ErrorDTO> ResourceAccessExceptionHandler(ResourceAccessException ex){

			ErrorDTO error = new ErrorDTO(ex.getClass().toString(), ex.getMessage());

			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CallApiException.class)
	public ResponseEntity <ErrorDTO> CallApiExceptionHandler(CallApiException ex){

		ErrorDTO error = new ErrorDTO(ex.getClass().toString(), ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

