package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Failure extends Response {
	public Failure(String args, InputStream response, OutputStream command)
	{
		super(args, response, command);
	}
	
	public boolean handleResponse() throws IOException
	{
		// Response is in form: 301 failure:[message]
		command.write(args.getBytes());
		throw new ResponseFailureException();
	}
}
