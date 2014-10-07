package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import java.util.List;

public class ListScripts extends Command{
	public ListScripts(Connection connection)
	{
		super(connection);
	}
	
	public List<Script> getSripts()
	{
		// TODO Implement
		throw new UnsupportedOperationException();
	}
	
}
