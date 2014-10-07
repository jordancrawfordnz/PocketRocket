package com.sneakyrocket.pocketrocket.v1.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {
	
	private Socket socket;
	/*
	public Connection()
	{
	}
	*/
	
	public Connection(InetAddress server, int port) throws IOException
	{
		if(server == null)
			throw new IllegalArgumentException();
		this.socket = new Socket(server, port);
	}
	
	public OutputStream getOutput() throws IOException
	{
		return socket.getOutputStream();
	}
	
	public InputStream getInput() throws IOException
	{
		return socket.getInputStream();
	}
	
	
	public void sendRequest(String request) throws Exception
	{
		if(socket.isClosed())
		{
			throw new Exception("This connection is not open and cannot be used to send requests.");
		}
	}
}
