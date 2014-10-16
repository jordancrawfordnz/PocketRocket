package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.*;
import com.sneakyrocket.pocketrocket.v1.core.response.*;

/**
 * Helps set up the session by saying "hello" to the server and getting the port number for further session communication.
 * @author Jordan Crawford
 *
 */
public class SayHello extends Command{
	public SayHello(Connection connection)
	{
		super(connection);
	}
	
	/**
	 * Sends "hello" to the server and waits for a hello response. Returns the parsed port number to use for further session communications.
	 * @return
	 */
	public int getPort()
	{
		if(!connection.sendRequest("hello"))
			throw new CommandFailureException();
		ResponseHandler handler = ResponseHandler.getInstance();
		Response firstResponse = handler.getResponse(connection);
		if(firstResponse instanceof Hello)
		{
			firstResponse.process();
			return ((Hello)firstResponse).getPort();
		}
		else
			throw new CommandFailureException("Expected a hello, got " + firstResponse.getClass().toString());
	}
}
