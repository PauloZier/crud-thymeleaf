package br.com.standard.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlingController {

	@ExceptionHandler(Exception.class)
	public ModelAndView error(HttpServletRequest req, Exception ex) {

		ModelAndView modelView = new ModelAndView("error.html");
		
		modelView.addObject("message", ex.getMessage());
		
		modelView.addObject("url", req.getRequestURL());
		
		return modelView;
	}
}
