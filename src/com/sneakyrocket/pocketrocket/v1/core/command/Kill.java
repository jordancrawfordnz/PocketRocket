package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import java.util.List;

public class Kill extends Command {
	private Script script;
	public Kill(Connection connection, Script script)
	{
		super(connection);
		if(script == null)
			throw new IllegalArgumentException();
		this.script = script;
	}
	
	public void Kill()
	{
		// TODO Implement
	}
}
