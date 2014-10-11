package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.*;

public abstract class Response {
	protected String args;
	protected InputStream response;
	protected OutputStream command;
	
	// Args is anything after the ":" in the string
	public Response(String args, InputStream response, OutputStream command)
	{
		if(args == null || response == null)
			throw new IllegalArgumentException();
		this.args = args;
		this.response = response;
		this.command = command;
	}

	// Returns true if end of response chain (and no more lines need handling), false otherwise.
	public abstract boolean handleResponse() throws IOException;

}
