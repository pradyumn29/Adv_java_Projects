package com.app.Global;

import javax.el.MethodNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.dto.ApiresponseDTO;
import com.app.exception.CustomisedException;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MethodNotFoundException.class)
	public ResponseEntity<?> methodnotfoundexception(MethodNotFoundException m){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		.body(new ApiresponseDTO("MethodNotFoundException"+m.getCause()));
	}
	
	@ExceptionHandler(CustomisedException.class)
	public ResponseEntity<?>customisedexception(CustomisedException c){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiresponseDTO(c.getMessage()));
	}

}
