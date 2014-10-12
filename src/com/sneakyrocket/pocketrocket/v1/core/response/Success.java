package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class Success extends Response {
	public Success(String args, Connection connection)
	{
		super(args, connection);
	}

	// TODO Display message to user in run method?

	@Override
	public Response getNext() {
		return null;
	}
	
	public String getMessage() {
		return args;
	}
}
