package com.sneakyrocket.pocketrocket.v1.core.response;

import android.util.Log;
import android.util.SparseArray;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Reads the connection to determine the appropriate response, then creates the response after parsing its arguments.
 * @author Jordan Crawford
 *
 */
public class ResponseHandler {
	private static ResponseHandler instance;

	private SparseArray<Class<? extends Response>> responses = null;
	
	/**
	 * Sets up the list of known responses
	 */
	private ResponseHandler()
	{
		responses = new SparseArray<Class<? extends Response>>();
		// setup the response handlers with their codes
		responses.put(100, Done.class);
		responses.put(101, Success.class);
		responses.put(102, OkText.class);
		//responseHandlers.put(103, OkBytes.class);
		responses.put(300, CatastrophicFailure.class);
		responses.put(301, Failure.class);
		responses.put(302, InvalidCommand.class);
		responses.put(420, Hello.class);
	}
	
	/**
	 * If an instance does not exist, creates one.
	 * Returns the response handler.
	 * @return
	 */
	public static ResponseHandler getInstance()
	{
		if(instance == null)
			instance = new ResponseHandler();
		
		return instance;
	}
	
	/**
	 * Reads the connection.
	 * Determines the code of the response and the arguments section (anything after ":").
	 * Creates the relevant response handler.
	 * @param connection
	 * @return
	 */
	public Response getResponse(Connection connection)
	{
		try
		{
			BufferedReader reader = connection.getNetworkInput();
			String responseLine = reader.readLine();
			if (responseLine == null)
			{
				Log.d(GlobalApplication.getInstance().getResources()
						.getString(R.string.app_name), "End of transmission");
				return null;
			}
			Log.d(GlobalApplication.getInstance().getResources()
					.getString(R.string.app_name), responseLine);
			
			String[] splitResponse = responseLine.split(" ",2);
			String textCode = splitResponse[0];
			
			//Are our codes guaranteed to be 3 digits?
			if(textCode.length() != 3)
				return new CatastrophicFailure("Unrecognised response code", connection);
			
			int code = Integer.parseInt(textCode);
			
			String args = "";
			if(splitResponse.length > 1)
			{
				String toArgsSplit = splitResponse[1];
				//Is the limit 2 or 1?
				String[] argsSplit = toArgsSplit.split(":", 2);
				if(argsSplit.length > 1)
					args = argsSplit[1];
			}
			else
				return new CatastrophicFailure("Response name is missing", connection);
			
			Class<? extends Response> handlerClass = responses.get(code);
			
			if (handlerClass == null)
				return new CatastrophicFailure("Server's response is not registered", connection);
			
			Constructor<? extends Response> constructHandler = handlerClass.getDeclaredConstructor(String.class, Connection.class);
			return constructHandler.newInstance(args, connection);
		}
		catch (InstantiationException e)
		{
			return new CatastrophicFailure(e.getMessage(), connection);
		}
		catch (NoSuchMethodException e)
		{
			return new CatastrophicFailure(e.getMessage(), connection);
		}
		catch (IllegalAccessException e)
		{
			return new CatastrophicFailure(e.getMessage(), connection);
		}
		catch (InvocationTargetException e)
		{
			return new CatastrophicFailure(e.getMessage(), connection);
		}
		catch(IOException e)
		{
			return new CatastrophicFailure(e.getMessage(), connection);
		}
	}
}
