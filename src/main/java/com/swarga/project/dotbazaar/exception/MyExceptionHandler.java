package com.swarga.project.dotbazaar.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public String  exceptionHandlerConstraintViolationException(DataIntegrityViolationException e, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		redirectAttributes.addFlashAttribute("error", "Error: This Username/ emailID is already registered!!");
		return "redirect:/";

	}
	
	@ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		ex.printStackTrace();
		redirectAttributes.addFlashAttribute("error", "Error: Unable to Register User!!");
		return "redirect:/";

    }
}
