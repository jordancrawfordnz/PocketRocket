package com.sneakyrocket.pocketrocket.v1.ui.server;

import java.net.UnknownHostException;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Session;
import com.sneakyrocket.pocketrocket.v1.remote.Server;
import com.sneakyrocket.pocketrocket.v1.ui.scripts.ScriptListingActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ServerClickListener implements OnClickListener{
	private Server server;
	
	public ServerClickListener(Server server) {
		this.server = server;
	}

	@Override
	public void onClick(View view) {
		Context context = view.getContext();
		
		try {
			Session session = new Session(server);
			Session.setCurrentSession(session);
			Intent intent = new Intent(context, ScriptListingActivity.class);
			context.startActivity(intent);
		} catch(UnknownHostException e) {
			Toast.makeText(context, R.string.address_unresolvable, Toast.LENGTH_LONG).show();
		}
	}
}
