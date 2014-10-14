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
	private final TextView view;
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
					output.append('\n');
					view.post(new Runnable(){
						@Override
						public void run() {
							view.setText(output.toString());
						}
					});
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
