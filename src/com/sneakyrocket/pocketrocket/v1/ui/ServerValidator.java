package com.sneakyrocket.pocketrocket.v1.ui;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.remote.Server;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.widget.TextView;

public class ServerValidator implements OnClickListener {
	private ServerBrowserActivity browser;
	
	public ServerValidator(ServerBrowserActivity browser) {
		this.browser = browser;
	}

	@Override
	/**
	 * Class to validate server names and addresses
	 */
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case AlertDialog.BUTTON_POSITIVE:
			TextView nameView = (TextView) browser.findViewById(R.id.serverName);
			TextView addressView = (TextView) browser.findViewById(R.id.serverAddress);
			Server server = new Server(nameView.getText().toString(),
					addressView.getText().toString());
			browser.addServer(server);
			break;
		case AlertDialog.BUTTON_NEGATIVE:
			dialog.cancel();
			break;
		}

	}
}
