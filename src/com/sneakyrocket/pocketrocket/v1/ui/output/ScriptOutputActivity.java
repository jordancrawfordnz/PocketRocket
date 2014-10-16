package com.sneakyrocket.pocketrocket.v1.ui.output;

import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Simple activity to start a script and display the output
 * to the screen.
 * @author Andrew
 *
 */
public class ScriptOutputActivity extends ActionBarActivity {
	private ScriptOutput output;

	
	@Override
	/**
	 * Reads the intent for an extra parameter 'Script', which it uses to
	 * run the script on the server.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String scriptName = intent.getStringExtra("Script");
		setTitle(scriptName);
		TextView outputView = new TextView(this);
		setContentView(outputView);
		output = new ScriptOutput(outputView,
				new Script(Session.getCurrentSession(), scriptName));
		new Thread(output).start();
	}

}
