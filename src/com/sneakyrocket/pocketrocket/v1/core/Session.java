package com.sneakyrocket.pocketrocket.v1.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.sneakyrocket.pocketrocket.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Session {
	private static Session instance = null;
	
	private InetAddress server;
	
	public static synchronized void setCurrentSession(Session session)
	{
		instance = session;
	}
	
	public static synchronized Session getCurrentSession()
	{
		return instance;
	}
	
	public Session(Server target) throws UnknownHostException
	{
		if(target == null)
		{
			throw new IllegalArgumentException();
		}
		this.server = InetAddress.getByName(target.getAddress());
		
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
		//Returns a default image for testing purposes
		return BitmapFactory.decodeResource(
				GlobalApplication.getInstance().getResources(),
				R.drawable.ic_action_cast);
	}

}
