package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

/**
 * Denotes the end of a connection, so closes the connection.
 * @author Andrew Williamson
 */
public class Done extends Response {
	public Done(String args, Connection connection) {
		super(args, connection);
	}

	@Override
	public void process() {
		connection.close();
	}
}
