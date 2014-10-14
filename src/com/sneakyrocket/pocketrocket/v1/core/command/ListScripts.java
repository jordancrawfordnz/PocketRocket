package com.sneakyrocket.pocketrocket.v1.core.command;

import android.util.Log;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;
import com.sneakyrocket.pocketrocket.v1.core.response.Hello;
import com.sneakyrocket.pocketrocket.v1.core.response.OkText;
import com.sneakyrocket.pocketrocket.v1.core.response.Response;
import com.sneakyrocket.pocketrocket.v1.core.response.ResponseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListScripts extends Command{
	public ListScripts(Connection connection)
	{
		super(connection);
	}
	
	public ArrayList<Script> getSripts()
	{
		// Send off the request to the server.
		if(!connection.sendRequest("listScripts"))
			throw new CommandFailureException();
		ResponseHandler handler = ResponseHandler.getInstance();
		Response firstResponse = handler.getResponse(connection);
		
		Session currentSession = Session.getCurrentSession();
		ArrayList<Script> scriptList = new ArrayList<Script>();
		firstResponse.process();
		
		if(firstResponse instanceof OkText)
		{
			OkText response = (OkText) firstResponse;
			BufferedReader textOutput = response.getReader();
			String line;	
			try
			{
				while((line = textOutput.readLine()) != null)
				{
					scriptList.add(new Script(currentSession,line));
				}
			}
			catch(IOException ex)
			{
				Log.d(GlobalApplication.getInstance().getResources()
						.getString(R.string.app_name), ex.getMessage());
				throw new CommandFailureException();
			}
		}
		else
			throw new CommandFailureException();
		return scriptList;
	}
	
}
