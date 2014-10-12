package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class Hello extends Response {
	private int port;
	
	public Hello(String args, Connection connection) {
		super(args, connection);
		port = -1;
	}

	@Override
	public void process() {
		port = Integer.parseInt(args);
		super.process();
	}
	
	public int getPort() {
		return port;
	}
}
