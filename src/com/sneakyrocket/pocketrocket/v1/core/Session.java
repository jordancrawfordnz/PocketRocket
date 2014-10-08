package com.sneakyrocket.pocketrocket.v1.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;

public class Session {
	
	private InetAddress server;
	private Context context;
	
	public Session(String target, Context context) throws UnknownHostException
	{
		if(target == null || context == null)
		{
			throw new IllegalArgumentException();
		}
		this.context = context;
		this.server = InetAddress.getByName(target);
		
		// TODO Create a ServerListingActivity
		// TODO Determine port for session to communicate on.
	}
	
	// TODO Finish
	public void runScript(Script script)
	{
		
	}
	
	// TODO Finish
	public void killScript(Script script)
	{
		
	}
	
	// TODO Finish
	public List<Script> listScripts()
	{
		// return some hard coded values for testing purposes
		ArrayList<Script> toReturn = new ArrayList<Script>();
		toReturn.add(new Script(this, "RestartApache"));
		toReturn.add(new Script(this, "RestartComputer"));
		toReturn.add(new Script(this, "NextSong"));
		toReturn.add(new Script(this, "RmRfAllFiles"));
		
		return (List<Script>) toReturn;
	}
	
	// TODO Finish
	public Bitmap getIcon(Script script)
	{
		throw new UnsupportedOperationException();
	}

}
