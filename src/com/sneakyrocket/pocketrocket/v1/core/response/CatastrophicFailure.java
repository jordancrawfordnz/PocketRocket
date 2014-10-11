package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CatastrophicFailure extends Response {
	public CatastrophicFailure(String args, InputStream response, OutputStream command)
	{
		super(args, response, command);
	}
	
	public boolean handleResponse() throws IOException
	{
		throw new ResponseFailureException();
	}
}
