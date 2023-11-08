package com.ty.hrms.exception;

public class NoBatchesExistException extends RuntimeException {

	private String msg;

	public NoBatchesExistException(String msg) {
		
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
