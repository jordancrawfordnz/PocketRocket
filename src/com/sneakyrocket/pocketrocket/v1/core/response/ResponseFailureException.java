package com.sneakyrocket.pocketrocket.v1.core.response;

/**
 * Thrown any time a response fails, usually when it cannot be parsed correctly or an I/O error occurs.
 * @author Jordan Crawford
 *
 */
public class ResponseFailureException extends RuntimeException {

	private static final long serialVersionUID = -8516622041412398465L;

	public ResponseFailureException()
	{
		super();
	}
}
