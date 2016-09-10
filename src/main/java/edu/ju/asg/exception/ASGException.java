package edu.ju.asg.exception;

public class ASGException extends Exception {

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = -8940000305086791690L;

	/**
	 * THe default constructor
	 */
	public ASGException() {

	}

	/**
	 * Constructs an Exception with the specified message
	 * 
	 * @param message
	 *            The Error Message
	 */
	public ASGException(final String message) {
		super(message);
	}

	/**
	 * Constructs an Exception with the specified message and Throwable Cause
	 * 
	 * @param message
	 *            The Error Message
	 * @param t
	 *            The throwable
	 */
	public ASGException(final String message, final Throwable t) {
		super(message, t);
	}

}
