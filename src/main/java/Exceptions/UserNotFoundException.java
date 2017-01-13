package Exceptions;

public class UserNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1940295741647877711L;

	public UserNotFoundException() {
		super("User not found!");
	}
}
