package com.sneakyrocket.pocketrocket.v1.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 
 * @author Jordan Crawford
 *
 * Controls access to network sockets
 * 
 */
public class Connection {
	
	private Socket socket;
	private BufferedReader networkInput;
	
	/**
	 * Creates a new socket given an InetAddress and port
	 * @param server
	 * @param port
	 * @throws IOException
	 */
	public Connection(InetAddress server, int port) throws IOException
	{
		if(server == null)
			throw new IllegalArgumentException();
		this.socket = new Socket(server, port);
		networkInput = new BufferedReader(
				new InputStreamReader(this.socket.getInputStream()));
	}
	
	/**
	 * Closes the socket.
	 */
	public void close()
	{
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
	
	/**
	 * Sends a string off through the connection.
	 * Returns true or false, depending on if it sent sucessfully.
	 * Does not wait for a response from the server!
	 * @param request
	 * @return
	 */
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
	
	/**
	 * Gets the input stream of the incoming response from the server.
	 * @return
	 * @throws IOException
	 */
	public BufferedReader getNetworkInput() throws IOException
	{
		return networkInput;
	}
	
}
