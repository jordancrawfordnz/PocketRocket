package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

/**
 * When an issue occurs on the server, shows the message to the user as a toast.
 * @author Jordan Crawford
 *
 */
public class Failure extends Response {
	public Failure(String args, Connection connection) {
		super(args, connection);
	}

	@Override
	public void process() {
		// TODO Display toast to user
		super.process();
	}
	
	public String getMessage() {
		return args;
	}
}
