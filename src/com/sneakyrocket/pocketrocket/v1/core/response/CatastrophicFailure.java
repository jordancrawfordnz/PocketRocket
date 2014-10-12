package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public class CatastrophicFailure extends Response {
	public CatastrophicFailure(String args, Connection connection) {
		super(args, connection);
	}
	
	//TODO: Display toast to user after processing?
}
