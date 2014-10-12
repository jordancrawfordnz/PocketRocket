package com.sneakyrocket.pocketrocket.v1.ui.server;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Server;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.TextView;

public class ServerValidator implements OnClickListener {
	private View dialogView;
	private ServerBrowserActivity target;
	private Server server = null;
	
	public ServerValidator(View dialogView, ServerBrowserActivity target) {
		this.dialogView = dialogView;
		this.target = target;
	}

	@Override
	/**
	 * Class to validate server names and addresses
	 */
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case AlertDialog.BUTTON_POSITIVE:
			TextView nameView = (TextView) dialogView.findViewById(R.id.newServerName);
			TextView addressView = (TextView) dialogView.findViewById(R.id.newServerAddress);
			TextView portView = (TextView) dialogView.findViewById(R.id.newServerPort);
			server = new Server(
					nameView.getText().toString(),
					addressView.getText().toString(),
					Integer.parseInt(portView.getText().toString()));
			validate();
			break;
		case AlertDialog.BUTTON_NEGATIVE:
			dialog.cancel();
			break;
		}
	}
	
	public void validate(){
		target.addServer(server);
	}
}
