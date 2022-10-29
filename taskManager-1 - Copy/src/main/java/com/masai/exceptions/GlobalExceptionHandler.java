package com.masai.exceptions;

import java.time.LocalDateTime;

import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<MyErrorDetails> CustomExceptionHander(CustomException ce, WebRequest req){
		
		MyErrorDetails err = new  MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails> (err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> NotFoundExceptionHandler(NotFoundException nfe, WebRequest req){
		
		MyErrorDetails err = new  MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails> (err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> CustomExceptionHander(Exception e, WebRequest req){
		
		MyErrorDetails err = new  MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails> (err,HttpStatus.NOT_FOUND);
		
	}
	
}
