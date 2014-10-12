package com.sneakyrocket.pocketrocket.v1.ui.scripts;

import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * Class to listen for and handle click events for a particular script
 * @author Andrew
 *
 */
public class ScriptClickListener implements OnClickListener {
	private Session session;
	private Script script;
	
	/**
	 * Creates a new listener from the specified parameters
	 * @param session
	 * @param script
	 */
	public ScriptClickListener(Session session, Script script) {
		this.session = session;
		this.script = script;
	}
	
	
	@Override
	public void onClick(View view) {
		// TODO Run script in new activity
		
	}
}
