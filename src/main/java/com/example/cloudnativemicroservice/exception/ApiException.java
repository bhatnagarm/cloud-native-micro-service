package com.example.cloudnativemicroservice.exception;

class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6007047827050348535L;
	
	private int code;

	public ApiException(final int code, final String msg) {
		super(msg);
		this.code = code;
	}
}
