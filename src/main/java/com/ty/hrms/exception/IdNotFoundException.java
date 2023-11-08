package com.ty.hrms.exception;

public class IdNotFoundException extends RuntimeException {

	private String msg;

	public IdNotFoundException(String msg) {
		
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
}
