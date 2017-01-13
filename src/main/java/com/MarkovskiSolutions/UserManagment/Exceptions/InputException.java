package com.MarkovskiSolutions.UserManagment.Exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class InputException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8716655003992542611L;
	private String message;
	String newline = System.getProperty("line.separator");

	public InputException(ConstraintViolationException ex) {
		StringBuilder sb = new StringBuilder();
		for (ConstraintViolation<?> v : ex.getConstraintViolations()) {
			sb.append(v.getMessage() + newline);
		}
		
		this.message = sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

}
