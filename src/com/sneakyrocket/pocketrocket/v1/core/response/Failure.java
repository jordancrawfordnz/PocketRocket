package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class Failure extends Response {
	public Failure(String args, Connection connection) {
		super(args, connection);
	}

	@Override
	public void run() {
		// TODO Display toast to user
	}
	
	public String getMessage() {
		return args;
	}
}
