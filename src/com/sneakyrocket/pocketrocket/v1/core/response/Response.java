package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public abstract class Response {
	protected String args;
	protected InputStream inputStream;
	
	// Args is anything after the ":" in the string
	public Response(String args, InputStream inputStream)
	{
		if(args == null || inputStream == null)
			throw new IllegalArgumentException();
		this.args = args;
		this.inputStream = inputStream;
	}
	
	// TODO Implement as a singleton instead?
	
	public static void Handle(String responseLine, InputStream inputStream)
	{
		if(responseHandlers == null)
		{
			responseHandlers = new HashMap<Integer,  Class<? extends Response>>();
			responseHandlers.put(100, Done.class);
			
		}
		if(responseLine == null || inputStream == null)
			throw new IllegalArgumentException();
		
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
		// TODO Change from test args
		
		if(responseHandlers.containsKey(code)) // if this is a code we know how to handle
		{
			Class<? extends Response> handlerClass = responseHandlers.get(code);
			try
			{
				Constructor<? extends Response> constructHandler = handlerClass.getDeclaredConstructor(String.class,InputStream.class);
				Response handler = constructHandler.newInstance(args, inputStream);
				((Done)handler).getArgs();
			}
			// If anything went wrong with finding the constructors, don't bother fixing it.
			catch(NoSuchMethodException ex) {
			}
			catch (InstantiationException e) {
			} 
			catch (IllegalAccessException e) {
			}
			catch (IllegalArgumentException e) {
			}
			catch (InvocationTargetException e) {
			}
		}
	}
	
	private static HashMap<Integer, Class<? extends Response>> responseHandlers = null;

}
