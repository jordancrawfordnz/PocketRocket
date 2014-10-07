package com.sneakyrocket.pocketrocket.v1.core;

import android.graphics.Bitmap;

public class Script {
	private Bitmap icon = null;
	private String name;
	private Session session;
	
	// TODO How to handle a class that an instance is created of but it doesn't exist (or no longer exists)
	
	public Script(Session session, String name)
	{
		if(session == null || name == null)
			throw new IllegalArgumentException();
		this.name = name;
		this.session = session;
	}
	
	public Bitmap getIcon()
	{
		if(this.icon == null)
		{
			icon = session.getIcon(this);
			// if an icon cannot be found, will try to find one every time it is accessed
		}
		return icon;
	}
	
	public String getName()
	{
		return name;
	}
}
