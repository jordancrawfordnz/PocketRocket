package com.sneakyrocket.pocketrocket.v1.core.command;

import java.io.OutputStream;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;

public class Run extends Command {
	private Script script;
	public Run(Connection connection, Script script)
	{
		super(connection);
		if(script == null)
			throw new IllegalArgumentException();
		this.script = script;
	}
	
	public OutputStream getStream()
	{
		// TODO Implement
		throw new UnsupportedOperationException();
	}
}
