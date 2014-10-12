package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class InvalidCommand extends Response {
	public InvalidCommand(String args, Connection connection) {
		super(args, connection);
	}
}
