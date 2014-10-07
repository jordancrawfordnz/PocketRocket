package com.sneakyrocket.pocketrocket.v1.core;

import java.util.Dictionary;

public abstract class Response {
	private String args;
	private Connection connection;
	
	public Response(String args, Connection connection)
	{
		if(args == null || connection == null)
			throw new IllegalArgumentException();
		this.args = args;
		this.connection = connection;
	}
	
	public static void Handle(String args, Connection connection)
	{
		// TODO Finds the correct response handler
	}
	
	private static Dictionary<Integer, Class> responseHandlers;
	
}
