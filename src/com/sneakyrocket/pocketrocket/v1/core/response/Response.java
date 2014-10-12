package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public abstract class Response implements Runnable {
	protected volatile Object lock;
	protected String args;
	protected Connection connection;
	protected Response nextResponse;
	protected boolean finished;
	
	// Args is anything after the ":" in the string
	public Response(String args, Connection connection) {
		if(args == null || connection == null)
			throw new IllegalArgumentException();
		this.args = args;
		this.connection = connection;
		this.nextResponse = null;
	}

	// handles itself
	public void run() {
		synchronized (lock) {
			finished = true;
		}
	}

	public Response getNext() {
		return ResponseHandler.getInstance().getResponse(connection);
	}
}
