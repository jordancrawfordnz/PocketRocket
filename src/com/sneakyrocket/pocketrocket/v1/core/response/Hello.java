package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Hello extends Response {
	public Hello(String args, InputStream response, OutputStream command)
	{
		super(args, response, command);
	}
	
	public boolean handleResponse() throws IOException
	{
		// Response is in form: 420 hello:[port]
		command.write(args.getBytes());
		return false;
	}
}
