package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

/**
 * For when the server responds that some action completed sucessfully.
 * For example, killing a script.
 * @author Jordan Crawford
 *
 */
public class Success extends Response {
	public Success(String args, Connection connection)
	{
		super(args, connection);
	}

	@Override
	public void process() {
		// TODO Display message to user?
	}
	
	public String getMessage() {
		return args;
	}
}
