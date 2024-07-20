package com.org.realtimejavaapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdvise extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> emptyInputExceptionHandller(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("filed details are not found plese check once",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NodetailsFoundException.class)
	public ResponseEntity<String> nodetailsFoundExceptionHandller(NodetailsFoundException nodetailsFoundException){
		return new ResponseEntity<String>(" No Details Found 	filed is empty please look it once",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NoRecordsFoundException.class)
	public ResponseEntity<String> noRecordsFoundExceptionHandller(NoRecordsFoundException noRecordsFoundException){
		return new ResponseEntity<String>("There is No records Found please check it once...",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<String> nullPointerException(ClassNotFoundException classNotFoundException){
		return new ResponseEntity<String>("please check once your class is not found",HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerException(NullPointerException nullPointerException){
		return new ResponseEntity<String>("Given input no date availbale please check and change",HttpStatus.BAD_REQUEST);
		
	}

}
