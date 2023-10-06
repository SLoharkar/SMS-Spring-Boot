package com.example.demo.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo.Exception.Pojo.ExceptionConfiguration;


@RestControllerAdvice 
public class ControllerException	{
	
	
	
	//Handle Payload Exception
	@ExceptionHandler({NumberFormatException.class,MethodArgumentTypeMismatchException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ExceptionConfiguration PayloadException(Exception e){
		return new ExceptionConfiguration(new Date(),400,"NumberFormatException","Passing Invalid Argument");
	}
	
	
	//Handle Method Not Support/Method Not Allowed Exception
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ExceptionConfiguration MethodNotAllowedException(Exception e){
		return new ExceptionConfiguration(new Date(), 405, "MethodNotAllowedException", "Passing Data From Invalid HTTP Method");
	}
	
	
	//Handle Invalid Request Body Exception
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionConfiguration InvalidRequestBodyException(Exception e){
		return new ExceptionConfiguration(new Date(), 400,"InvalidRequestBodyException", "Pass Proper Data in JSON");
	}
	
	
	//Handle Data Not Found Exception
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionConfiguration DataNotFoundException(DataNotFoundException ex) {
		return new ExceptionConfiguration(new Date(),404,"DataNotFoundException",ex.getMessage());
	}

	
	
}
