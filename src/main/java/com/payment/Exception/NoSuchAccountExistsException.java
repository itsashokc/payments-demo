package com.payment.Exception;

public class NoSuchAccountExistsException extends RuntimeException {

	
	private static final long serialVersionUID = -7000820199213229396L;
	private String message;

	public NoSuchAccountExistsException() {
	}

	public NoSuchAccountExistsException(String msg) {
		super(msg);
		this.message = msg;
	}

}
