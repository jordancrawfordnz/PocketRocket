package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.InputStream;

public class Done extends Response {
	public Done(String args, InputStream inputStream)
	{
		super(args, inputStream);
	}
	
	// TODO Remove when no longer needed
	public void getArgs()
	{
		System.out.println("DONE: " + args);
	}
	
}
