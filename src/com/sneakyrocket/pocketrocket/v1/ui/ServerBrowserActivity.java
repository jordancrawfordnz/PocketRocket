package com.sneakyrocket.pocketrocket.v1.ui;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.remote.Server;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * ServerBrowserActivity is the activity used to view, add, and remove
 * a user's known servers.
 * @author Andrew
 *
 */
public class ServerBrowserActivity extends ActionBarActivity {
	private BasicListAdapter adapter;
	private ListView serverListView;
	//TODO: add member variables as classes are made
	
	public ServerBrowserActivity() {
		adapter = new BasicListAdapter();
	}
	
		@Override
		/**
		 * This method is called when the activity is first created. All
		 * previously saved servers should be reloaded here, and shown to
		 * the user.
		 */
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setTitle(R.string.server_browser_title);
			setContentView(R.layout.server_browser_layout);
			serverListView = (ListView) findViewById(R.id.serverList);
			serverListView.setAdapter(adapter);
			//TODO: add list of servers
		}
		
		@Override
		/**
		 * This method is called when the options menu (in the action bar)
		 * is first loaded. This is where the menu should be inflated.
		 */
		public boolean onCreateOptionsMenu(Menu menu) {
		    getMenuInflater().inflate(R.menu.server_browser_menu, menu);
		    return super.onCreateOptionsMenu(menu);
		}
		
		@Override
		/**
		 * This method is called when anything in the action bar is
		 * selected. If the selection is handled, the method returns true.
		 */
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case R.id.action_new_server:
				LayoutInflater inflater = getLayoutInflater();
				View dialogView = inflater.inflate(R.layout.add_server_layout, serverListView, false);
				ServerValidator validator = new ServerValidator(dialogView, this);
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle(R.string.add_server);
				builder.setView(dialogView);
				builder.setPositiveButton(R.string.ok, validator);
				builder.setNegativeButton(R.string.cancel, validator);
				builder.create().show();
				return true;
			
			default:
				return false;
			}
		}
		
		public void addServer(Server server) {
			View serverView = getLayoutInflater().inflate(R.layout.server_layout, serverListView, false);
			TextView serverName = (TextView) serverView.findViewById(R.id.serverName);
			TextView serverDetails = (TextView) serverView.findViewById(R.id.serverDetails);
			serverName.setText(server.getName());
			serverDetails.setText(server.getAddress() + ":" + server.getPort());
			adapter.addView(serverView);
		}
}
