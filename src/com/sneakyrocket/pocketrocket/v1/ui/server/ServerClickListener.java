package com.sneakyrocket.pocketrocket.v1.ui.server;

import java.io.IOException;
import java.net.UnknownHostException;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Server;
import com.sneakyrocket.pocketrocket.v1.core.Session;
import com.sneakyrocket.pocketrocket.v1.core.command.CommandFailureException;
import com.sneakyrocket.pocketrocket.v1.ui.scripts.ScriptListingActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
		} catch(CommandFailureException e) {
			Toast.makeText(context, R.string.host_unreachable, Toast.LENGTH_LONG).show();
			Log.e(context.getResources().getString(R.string.app_name), e.getMessage());
		} catch(UnknownHostException e) {
			Toast.makeText(context, R.string.address_unresolvable, Toast.LENGTH_LONG).show();
			Log.e(context.getResources().getString(R.string.app_name), e.getMessage());
		} catch(IOException e) {
			Toast.makeText(context, R.string.io_error_occured, Toast.LENGTH_LONG).show();
			Log.e(context.getResources().getString(R.string.app_name), e.getMessage());
		}
	}
}
