package com.nelioalves.workshopmongo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.workshopmongo.Services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFount(
			ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		//criando o método para gerar o exception personalizado
		StandardError err = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Não Encontrado",
				e.getMessage(),
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
}
