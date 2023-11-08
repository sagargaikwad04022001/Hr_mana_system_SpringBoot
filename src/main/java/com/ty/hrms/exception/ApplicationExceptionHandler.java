package com.ty.hrms.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.hrms.response.ResponseStructure;
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchBatchNFE(IdNotFoundException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Not Found");
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
	
	
	@ExceptionHandler(NoBatchesExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoBatchE(NoBatchesExistException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Not Assigned");
		rs.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class )
	public ResponseEntity<ResponseStructure<String>> catchDataIntegrity(DataIntegrityViolationException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("Email already exist");
		rs.setData("Duplicate entry");
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(UserEmailNotExistException.class )
	public ResponseEntity<ResponseStructure<String>> catchDataIntegrity(UserEmailNotExistException exception)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setMsg("User Not Found");
		rs.setData("Invalid Credentials");
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NO_CONTENT);
	}
 
	
	
	
}
