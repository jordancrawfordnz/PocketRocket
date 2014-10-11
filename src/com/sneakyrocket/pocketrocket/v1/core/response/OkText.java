package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OkText extends Response {
	public OkText(String args, InputStream response, OutputStream command)
	{
		super(args, response, command);
	}
	
	public boolean handleResponse() throws IOException
	{
		// Takes over response until an end of transmission character is received.
		
		return false;
	}
}
