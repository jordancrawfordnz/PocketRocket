package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.response.Done;
import com.sneakyrocket.pocketrocket.v1.core.response.OkText;
import com.sneakyrocket.pocketrocket.v1.core.response.Response;
import com.sneakyrocket.pocketrocket.v1.core.response.ResponseHandler;

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
	
	public void kill()
	{
		if(!connection.sendRequest("kill " + script.getName()))
			throw new CommandFailureException();
		ResponseHandler handler = ResponseHandler.getInstance();
		Response firstResponse = handler.getResponse(connection);
		firstResponse.process();
		if(!(firstResponse instanceof Done)) // if did not complete sucessfully
			throw new CommandFailureException();
	}
}
