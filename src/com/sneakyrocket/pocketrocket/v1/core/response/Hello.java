package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class Hello extends Response {
	private int port;
	
	public Hello(String args, Connection connection) {
		super(args, connection);
		port = -1;
	}

	@Override
	public void run() {
		synchronized (lock) {
			port = Integer.parseInt(args);
			finished = true;
		}
	}
	
	public int getPort() {
		synchronized (lock) {
			return port;
		}
	}
}
