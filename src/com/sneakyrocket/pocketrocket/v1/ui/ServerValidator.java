package com.sneakyrocket.pocketrocket.v1.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

public class ServerValidator implements OnClickListener {

	@Override
	/**
	 * Class to validate server names and addresses
	 */
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case AlertDialog.BUTTON_POSITIVE:
			//TODO:
			Log.e("PocketRocket", "Not yet implemented!");
			break;
		case AlertDialog.BUTTON_NEGATIVE:
			dialog.cancel();
			break;
		}

	}

}
