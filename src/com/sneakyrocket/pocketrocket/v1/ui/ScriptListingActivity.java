package com.sneakyrocket.pocketrocket.v1.ui;

import com.sneakyrocket.pocketrocket.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * ScriptListingActivity is the activity a user will see when they first connect
 * to a server and obtain a list of all the runnable scripts.
 * @author Andrew
 *
 */
public class ScriptListingActivity extends ActionBarActivity {
	//TODO: add member variables as classes are made
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.script_list_title);
		setContentView(R.layout.script_list_layout);
		//TODO: add list of scripts
	}
}
