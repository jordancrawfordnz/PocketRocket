package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class Done extends Response {
	public Done(String args, Connection connection) {
		super(args, connection);
	}

	@Override
	public void process() {
		connection.close();
	}
}
