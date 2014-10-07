package com.sneakyrocket.pocketrocket.v1.remote;

/**
 * This class provides all the necessary information about a
 * remote server.
 * @author Andrew
 *
 */
public class Server {
	private String name;
	private String address;
	
	/**
	 * Creates a new server from the given parameters
	 * @param name
	 * @param address
	 */
	public Server(String name, String address) {
		this.name = name;
		this.address = address;
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
}
