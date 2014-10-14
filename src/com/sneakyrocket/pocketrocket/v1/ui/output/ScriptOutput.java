package com.sneakyrocket.pocketrocket.v1.ui.output;

import java.io.BufferedReader;
import java.io.IOException;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;

import android.util.Log;
import android.widget.TextView;

public class ScriptOutput implements Runnable {
	private TextView view;
	private Script target;
	private BufferedReader reader;
	private boolean finished = false;
	private StringBuilder output = new StringBuilder(128);
	
	public ScriptOutput(TextView view, Script target) {
		this.view = view;
		this.target = target;
	}

	@Override
	public void run() {
		reader = Session.getCurrentSession().runScript(target);
		while (!finished)
			try {
				String line = reader.readLine();
				if (line != null) {
					output.append(line);
					view.setText(output.toString());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
				else
					finished = true;
			} catch (IOException e) {
				Log.e(GlobalApplication.getInstance().getResources()
						.getString(R.string.app_name), e.getMessage());

			}
	}
	
	public boolean isFinished() {
		return finished;
	}
}
