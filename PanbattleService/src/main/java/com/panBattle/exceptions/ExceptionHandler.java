package com.panBattle.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ModalNullException.class)
	public ResponseEntity<String>handleException(ModalNullException excp)
	{
		return new ResponseEntity<String>(excp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
