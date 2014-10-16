package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public abstract class Response {
	protected String args;
	protected Connection connection;
	protected Response nextResponse;
	
	/**
	 * Sets up the response, storing its arguments, connection and the next response.
	 * @param args
	 * @param connection
	 */
	public Response(String args, Connection connection) {
		if(args == null || connection == null)
			throw new IllegalArgumentException();
		this.args = args;
		this.connection = connection;
		this.nextResponse = null;
	}
	
	/**
	 * Prepares the next response by getting the ResponseHandler to determine the next response for the connection.
	 */
	public void process() {
		nextResponse = ResponseHandler.getInstance().getResponse(connection);
		if(nextResponse != null)
			nextResponse.process();
	}

	/**
	 * Gets the next Response to be handled.
	 * @return
	 */
	public Response getNext() {
		return nextResponse;
	}
}
