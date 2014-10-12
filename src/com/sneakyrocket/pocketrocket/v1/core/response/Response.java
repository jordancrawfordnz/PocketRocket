package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public abstract class Response {
	protected String args;
	protected Connection connection;
	protected Response nextResponse;
	
	// Args is anything after the ":" in the string
	public Response(String args, Connection connection) {
		if(args == null || connection == null)
			throw new IllegalArgumentException();
		this.args = args;
		this.connection = connection;
		this.nextResponse = null;
	}
	
	public void process() {
		nextResponse = ResponseHandler.getInstance().getResponse(connection);
		nextResponse.process();
	}

	public Response getNext() {
		return nextResponse;
	}
}
