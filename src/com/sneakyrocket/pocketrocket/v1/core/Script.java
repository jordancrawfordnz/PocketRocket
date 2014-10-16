package com.sneakyrocket.pocketrocket.v1.core;

import android.graphics.Bitmap;

/**
 * Represents a script which can be started or killed.
 * @author Jordan Crawford
 *
 */
public class Script {
	private Bitmap icon = null;
	private String name;
	private Session session;
	
	/**
	 * 
	 * @param session
	 * @param name
	 */
	public Script(Session session, String name)
	{
		if(session == null || name == null)
			throw new IllegalArgumentException();
		this.name = name;
		this.session = session;
	}
	
	/**
	 * Gets the icon for the script. If the icon has not already been fetched, fetches the icon before returning it.
	 * @return The script's icon.
	 */
	public Bitmap getIcon()
	{
		if(this.icon == null)
		{
			icon = session.getIcon(this);
			// if an icon cannot be found, will try to find one every time it is accessed
		}
		return icon;
	}
	
	/**
	 * Gets the name of the script that was given to it when created.
	 * @return
	 */
	public String getName()
	{
		return name;
	}
}
