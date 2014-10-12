package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.*;
import com.sneakyrocket.pocketrocket.v1.core.response.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class SayHello extends Command{
	public SayHello(Connection connection)
	{
		super(connection);
	}
	
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
			throw new CommandFailureException();
	}
}
