package com.king.api.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.king.api.exception.UserNotFoundException;

@RestControllerAdvice
public class UserException {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public Map<String, String>  handleInvalidArgumentException(MethodArgumentNotValidException ex){
		Map<String, String> errorMap=new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
			{
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
				);
		return errorMap;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> UserNotFoundException(UserNotFoundException ex){
		Map<String, String> errorMap=new HashMap<String, String>();
		errorMap.put("Error Message", ex.getLocalizedMessage());
		return errorMap;
		
		
		
	}
	 
}
