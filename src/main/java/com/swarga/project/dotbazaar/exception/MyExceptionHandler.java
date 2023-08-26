package com.swarga.project.dotbazaar.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=DataIntegrityViolationException.class)
	@ResponseBody
	public Map<String,String>  exceptionHandlerConstraintViolationException(DataIntegrityViolationException e) {
		Map<String,String> response= new HashMap<String, String>();
		response.put("status", "error");
		response.put("message", "Error: This Username/ email is already registered!!");
		return response;
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
    public Map<String, String> handleGenericException(Exception ex) {
		Map<String,String> response= new HashMap<String, String>();
		response.put("status", "error");
		response.put("message", "Error: "+ex.getMessage());
		return response;

    }
}
