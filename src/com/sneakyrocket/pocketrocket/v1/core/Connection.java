package com.sneakyrocket.pocketrocket.v1.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {
	
	private Socket socket;
	private BufferedReader networkInput;
	
	// Gives the network input stream to the handler and an output stream for the handlers response.
	// The handlers response goes to the command through an input stream.
	public Connection(InetAddress server, int port) throws IOException
	{
		if(server == null)
			throw new IllegalArgumentException();
		this.socket = new Socket(server, port);
		networkInput = new BufferedReader(
				new InputStreamReader(this.socket.getInputStream()));
	}
	
	public void close()
	{
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
	
	// Returns true if the network request completed successfully.
	public boolean sendRequest(String request)
	{
		try
		{
			if(socket.isClosed())
			{
				return false;
			}
			socket.getOutputStream().write((request + "\n").getBytes()); // send the request to the server
		}
		catch (IOException ex)
		{
			return false;
		}
		return true;
	}
	
	public BufferedReader getNetworkInput() throws IOException
	{
		return networkInput;
	}
	
}
