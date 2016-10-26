package com.homello.exception;

public class UserExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2201602380386348939L;

	public UserExistException(String errorMsg) {
		super(errorMsg);
	}
}
