package com.sneakyrocket.pocketrocket.v1.ui.scripts;

import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;
import com.sneakyrocket.pocketrocket.v1.ui.output.ScriptOutputActivity;

import android.content.Context;
import android.content.Intent;
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
		Context context = view.getContext();
		Intent intent = new Intent(context, ScriptOutputActivity.class);
		intent.putExtra("Script", script.getName());
		context.startActivity(intent);
	}
}
