package com.sneakyrocket.pocketrocket.v1.ui;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;
import com.sneakyrocket.pocketrocket.v1.ui.server.BasicListAdapter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * ScriptListingActivity is the activity a user will see when they first connect
 * to a server and obtain a list of all the runnable scripts.
 * @author Andrew
 *
 */
public class ScriptListingActivity extends ActionBarActivity {
	private Session session;
	private BasicListAdapter adapter;
	private ListView scriptListView;
	
	/**
	 * Creates a new activity to show the list of scripts available in the
	 * current session.
	 */
	public ScriptListingActivity() {
		adapter = new BasicListAdapter();
		session = Session.getCurrentSession();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.script_list_title);
		setContentView(R.layout.script_list_layout);
		scriptListView = (ListView) findViewById(R.id.scriptList);
		scriptListView.setAdapter(adapter);
		for (Script script : session.listScripts())
			addScript(script);
	}
	
	/**
	 * Adds the given script to the list of scripts, and updates the view
	 * @param script the script to be added
	 */
	public void addScript(Script script) {
		View serverView = getLayoutInflater().inflate(R.layout.script_layout, scriptListView, false);
		TextView scriptName = (TextView) serverView.findViewById(R.id.scriptName);
		ImageView scriptIcon = (ImageView) serverView.findViewById(R.id.scriptIcon);
		scriptName.setText(script.getName());
		scriptIcon.setImageBitmap(script.getIcon());
		adapter.addView(serverView);
	}
}
