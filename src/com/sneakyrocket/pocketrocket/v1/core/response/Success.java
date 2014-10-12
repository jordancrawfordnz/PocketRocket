package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class Success extends Response {
	public Success(String args, Connection connection)
	{
		super(args, connection);
	}

	@Override
	public void process() {
		// TODO Display message to user?
		// Does the connection need to be closed here?
	}
	
	public String getMessage() {
		return args;
	}
}
