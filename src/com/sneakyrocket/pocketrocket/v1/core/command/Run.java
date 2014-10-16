package com.sneakyrocket.pocketrocket.v1.core.command;

import java.io.BufferedReader;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.response.OkText;
import com.sneakyrocket.pocketrocket.v1.core.response.Response;
import com.sneakyrocket.pocketrocket.v1.core.response.ResponseHandler;

/**
 * Runs a given script.
 * Designed to be constructed, retrieve the reader, then started in a new thread to begin processing the network input.
 * @author Jordan Crawford
 *
 */
public class Run extends Command implements Runnable
{
	private Script script;
	private BufferedReader stream;
	private OkText response = null;
	
	/**
	 * Sets up the run command with the Script to be run.
	 * @param connection
	 * @param script
	 */
	public Run(Connection connection, Script script)
	{
		super(connection);
		if(script == null)
			throw new IllegalArgumentException();
		this.script = script;
	}
	
	/**
	 * If the stream has not been setup, runs the command on the server and gets a BufferedReader for the text response from the server.
	 * Returns the stream.
	 * @return
	 */
	public BufferedReader getStream()
	{
		if(stream == null)
		{
			if(!connection.sendRequest("runScript " + script.getName()))
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

	/**
	 * Processes the response using a new thread, which will populate the reader.
	 */
	@Override
	public void run() {
		if(response != null)
			response.process();
	}
}
