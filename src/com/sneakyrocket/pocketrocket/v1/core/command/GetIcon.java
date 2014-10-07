package com.sneakyrocket.pocketrocket.v1.core.command;

import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import android.graphics.Bitmap;

public class GetIcon extends Command {
	
	private Script script;
	public GetIcon(Connection connection, Script script)
	{
		super(connection);
		if(script == null)
			throw new IllegalArgumentException();
		this.script = script;
	}
	
	public Bitmap getIcon()
	{
		// TODO Implement!
		throw new UnsupportedOperationException();
	}

}
