package com.sneakyrocket.pocketrocket.v1.core.command;

import java.io.BufferedReader;
import java.io.InputStream;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.response.Hello;
import com.sneakyrocket.pocketrocket.v1.core.response.OkText;
import com.sneakyrocket.pocketrocket.v1.core.response.Response;
import com.sneakyrocket.pocketrocket.v1.core.response.ResponseHandler;

public class Run extends Command implements Runnable
{
	private Script script;
	private BufferedReader stream;
	private OkText response = null;
	
	public Run(Connection connection, Script script)
	{
		super(connection);
		if(script == null)
			throw new IllegalArgumentException();
		this.script = script;
	}
	
	public BufferedReader getStream()
	{
		if(stream == null)
		{
			if(!connection.sendRequest("run " + script.getName()))
				throw new CommandFailureException();
			ResponseHandler handler = ResponseHandler.getInstance();
			Response firstResponse = handler.getResponse(connection);
			if(firstResponse instanceof OkText)
			{
				response = (OkText)firstResponse;
				stream = response.getReader();
			}
			else
				throw new CommandFailureException();
		}
		return stream;
	}

	@Override
	public void run() {
		if(response != null)
			response.process();
	}
}
