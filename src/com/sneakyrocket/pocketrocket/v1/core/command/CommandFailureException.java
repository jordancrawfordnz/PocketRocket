package com.sneakyrocket.pocketrocket.v1.core.command;

/**
 * To be thrown by any command which encounters an error while running.
 * This could be due to an error reported by the server or a network issue.
 * @author Jordan Crawford
 *
 */
public class CommandFailureException extends RuntimeException {
	
	private static final long serialVersionUID = -459462328269409237L;

	public CommandFailureException()
	{
		super();
	}
	
	public CommandFailureException(String message)
	{
		super(message);
	}
}
