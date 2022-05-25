package com.example.cloudnativemicroservice.exception;

public class NotFoundException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3883655039777174677L;

	private int code;

	public NotFoundException(final int code, final String msg) {
		super(404, msg);
		this.code = code;
	}
}
