package com.spring.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFonudException  extends RuntimeException {

	public ResourseNotFonudException(String message) {
		super(message);
	}
	
}
