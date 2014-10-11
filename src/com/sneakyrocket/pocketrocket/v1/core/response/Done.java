package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.InputStream;
import java.io.OutputStream;

public class Done extends Response {
	public Done(String args, InputStream response, OutputStream command)
	{
		super(args, response, command);
	}
	
	public boolean handleResponse()
	{
		return true;
	}
	
}
