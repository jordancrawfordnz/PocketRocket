package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.Connection;

public abstract class Command {
	
	protected Connection connection;
	
	public Command(Connection connection)
	{
		if(connection == null)
			throw new IllegalArgumentException();
		this.connection = connection;
	}

}
