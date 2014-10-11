package com.sneakyrocket.pocketrocket.v1.core.response;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ResponseHandler extends Thread {
	private InputStream commandResponse;
	private InputStream networkInput;
	private OutputStream handlerResponse;
	private boolean finished = false;
	private boolean successful = true;
	private Connection connection;
	
	private static HashMap<Integer, Class<? extends Response>> responseHandlers = null;
	
	public ResponseHandler(InputStream networkInput, Connection connection) throws IOException
	{
		if(networkInput == null || connection == null)
			throw new IllegalArgumentException();
		this.networkInput = networkInput;
		this.connection = connection;
		
		commandResponse = new PipedInputStream(); // the input stream to be read by the command
		handlerResponse = new PipedOutputStream((PipedInputStream) commandResponse); // the output stream to receive things from handlers
		// commandResponse and handlerResponse are linked together.
	}
	
	public void run()
	{
		if(responseHandlers == null)
		{
			responseHandlers = new HashMap<Integer,  Class<? extends Response>>();
			// setup the response handlers with their codes
			responseHandlers.put(100, Done.class);
			responseHandlers.put(101, Success.class);
			responseHandlers.put(102, OkText.class);
			//responseHandlers.put(103, OkBytes.class);
			responseHandlers.put(300, CatastrophicFailure.class);
			responseHandlers.put(301, Failure.class);
			responseHandlers.put(302, InvalidCommand.class);
			responseHandlers.put(420, Hello.class);
			
		}
		try
		{
			while(true)
			{
				String responseLine = new BufferedReader(new InputStreamReader(networkInput)).readLine();
				
				String[] splitResponse = responseLine.split(" ",2);
				String textCode = splitResponse[0];
				
				if(textCode.length() != 3)
					throw new IllegalArgumentException();
				// the code is valid
				
				int code = Integer.parseInt(textCode);
				
				String args = "";
				if(splitResponse.length > 1)
				{
					String toArgsSplit = splitResponse[1];
					String[] argsSplit = toArgsSplit.split(":", 2);
					if(argsSplit.length > 1)
						args = argsSplit[1];
				}
				
				if(responseHandlers.containsKey(code)) // if this is a code we know how to handle
				{
					Class<? extends Response> handlerClass = responseHandlers.get(code);
	
					try
					{
						Constructor<? extends Response> constructHandler = handlerClass.getDeclaredConstructor(String.class,InputStream.class, OutputStream.class);
						Response handler = constructHandler.newInstance(args, networkInput,handlerResponse);
						try
						{
							if(handler.handleResponse()) // if finishes response
							{
								finished = true;
								connection.close();
							}
						}
						catch(ResponseFailureException ex)
						{
							successful = false; // if any of the individual responses fail, the whole response fails.
						}
					}
					catch(NoSuchMethodException ex) {
						successful = false; 
					}
					catch (InstantiationException e) {
						successful = false; 
					} 
					catch (IllegalAccessException e) {
						successful = false; 
					}
					catch (IllegalArgumentException e) {
						successful = false; 
					}
					catch (InvocationTargetException e) {
						successful = false; 
					}
				}
			}
		}
		catch(IOException ex)
		{
			successful = false;
			finished = true;
		}
	}
	
	public boolean isFinished()
	{
		return finished;
	}
	
	public boolean isSuccessful()
	{
		return successful;
	}
	
	public InputStream getResponse()
	{
		return commandResponse;
	}
}
