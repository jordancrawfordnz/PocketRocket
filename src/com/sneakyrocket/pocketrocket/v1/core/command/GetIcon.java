package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import android.graphics.Bitmap;

/**
 * Request the server for an icon, uses OkBytes response.
 * @author Jordan Crawford
 *
 */
public class GetIcon extends Command {
	
	private Script script;
	
	/**
	 * 
	 * @param connection
	 * @param script
	 */
	public GetIcon(Connection connection, Script script)
	{
		super(connection);
		if(script == null)
			throw new IllegalArgumentException();
		this.script = script;
	}
	
	/**
	 * Sends the request to the server and returns the icon.
	 * @return
	 */
	public Bitmap getIcon()
	{
		// TODO Implement!
		throw new UnsupportedOperationException();
	}

}
