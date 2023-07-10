package com.app.exception_handler;

@SuppressWarnings("serial")
public class MovieNotFoundException extends RuntimeException {
	
	public MovieNotFoundException(String msg) {
		super(msg);
	}

}
