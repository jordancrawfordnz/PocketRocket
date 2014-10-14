package com.sneakyrocket.pocketrocket.v1.core;

/**
 * This class provides all the necessary information about a
 * remote server.
 * @author Andrew
 *
 */
public class Server {
	public static final int DEFAULT_PORT = 65535;
	
	private String name;
	private String address;
	private int port;
	
	/**
	 * Creates a new server from the given parameters
	 * @param name - the name of the server
	 * @param address - the IP address or URL of the server
	 * @param port - the port of the server
	 */
	public Server(String name, String address, int port) {
		if(name == null || address == null)
			throw new IllegalArgumentException();
		this.name = name;
		this.address = address;
		this.port = port;
	}
	
	/**
	 * Gets the name of this server
	 * @return the name of the server
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the address of this server
	 * @return the address of the server
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets the port of this server
	 * @return the port of the server
	 */
	public int getPort() {
		return port;
	}
}
