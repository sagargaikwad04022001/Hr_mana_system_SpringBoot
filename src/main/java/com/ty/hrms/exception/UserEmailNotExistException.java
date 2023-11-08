package com.ty.hrms.exception;

public class UserEmailNotExistException extends RuntimeException {

	private String msg;

	public UserEmailNotExistException(String msg) {		
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
