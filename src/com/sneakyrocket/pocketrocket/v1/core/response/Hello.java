package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

/**
 * Denotes the port number to use for the remainder of the session.
 * @author Jordan Crawford
 *
 */
public class Hello extends Response {
	private int port;
	
	public Hello(String args, Connection connection) {
		super(args, connection);
		port = -1;
	}

	/**
	 * Parses the port number before processing other responses.
	 */
	@Override
	public void process() {
		port = Integer.parseInt(args);
		super.process();
	}
	
	/**
	 * Gets th port number for the session.
	 * @return
	 */
	public int getPort() {
		return port;
	}
}
