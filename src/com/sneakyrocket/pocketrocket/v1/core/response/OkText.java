package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.BufferedReader;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class OkText extends Response {
	private BufferedReader reader;
	
	public OkText(String args, Connection connection)
	{
		super(args, connection);
	}

	@Override
	public void run() {
		// TODO Read text from connection, then finish
	}
	
	public BufferedReader getReader() {
		return reader;
	}
}
