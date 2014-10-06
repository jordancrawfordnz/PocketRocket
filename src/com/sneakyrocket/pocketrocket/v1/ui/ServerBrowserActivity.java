package com.sneakyrocket.pocketrocket.v1.ui;

import com.sneakyrocket.pocketrocket.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * ServerBrowserActivity is the activity used to view, add, and remove
 * a user's known servers.
 * @author Andrew
 *
 */
public class ServerBrowserActivity extends ActionBarActivity {
	//TODO: add member variables as classes are made
	
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setTitle(R.string.server_browser_title);
			setContentView(R.layout.server_browser_layout);
			//TODO: add list of servers
		}
}
