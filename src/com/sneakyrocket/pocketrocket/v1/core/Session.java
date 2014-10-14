package com.sneakyrocket.pocketrocket.v1.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.command.*;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Session {
	private static Session instance = null;
	
	private InetAddress server;
	private int port;
	
	public static synchronized void setCurrentSession(Session session)
	{
		instance = session;
	}
	
	public static synchronized Session getCurrentSession()
	{
		return instance;
	}
	
	public Session(Server target) throws IOException
	{
		if(target == null)
		{
			throw new IllegalArgumentException();
		}
		this.server = InetAddress.getByName(target.getAddress());
		
		Connection connection = new Connection(server, target.getPort());
		SayHello hello = new SayHello(connection);
		port = hello.getPort();
	}

	public BufferedReader runScript(Script script)
	{
		try
		{
			Run run = new Run(new Connection(server, port),script);
			BufferedReader toReturn = run.getStream();
			new Thread(run).start();
			return toReturn;
		}
		catch(IOException ex)
		{
			Log.d(GlobalApplication.getInstance().getResources()
					.getString(R.string.app_name), ex.getMessage());
			throw new CommandFailureException();
		}
	}
	
	public void killScript(Script script)
	{
		try
		{
			Kill kill = new Kill(new Connection(server, port),script);
			kill.kill();
		}
		catch(IOException ex)
		{
			Log.d(GlobalApplication.getInstance().getResources()
					.getString(R.string.app_name), ex.getMessage());
			throw new CommandFailureException();
		}
	}
	
	public ArrayList<Script> listScripts()
	{
		try {
			ArrayList<Script> toReturn = new ListScripts(new Connection(server,port)).getSripts();
			return toReturn;
		} catch (IOException e) {
			Log.d(GlobalApplication.getInstance().getResources()
					.getString(R.string.app_name), e.getMessage());
			throw new CommandFailureException();
		}
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
