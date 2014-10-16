package com.sneakyrocket.pocketrocket.v1.ui.output;

import java.io.BufferedReader;
import java.io.IOException;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;
import com.sneakyrocket.pocketrocket.v1.core.Script;
import com.sneakyrocket.pocketrocket.v1.core.Session;

import android.util.Log;
import android.widget.TextView;

/**
 * A class that, given a textview and a buffered reader, will continually
 * update the text in the textview to match the output of the buffered reader.
 * @author Andrew
 *
 */
public class ScriptOutput implements Runnable {
	private final TextView view;
	private Script target;
	private BufferedReader reader;
	private boolean finished = false;
	private StringBuilder output = new StringBuilder(128);
	
	/**
	 * Creates a new ScriptOutput from the given parameters.
	 * @param view the view to be updated
	 * @param target the script to be run
	 */
	public ScriptOutput(TextView view, Script target) {
		this.view = view;
		this.target = target;
	}

	@Override
	/**
	 * Runs the script provided in the constructor, and displays the output
	 * in the textview.
	 */
	public void run() {
		reader = Session.getCurrentSession().runScript(target);
		while (!finished)
			try {
				String line = reader.readLine();
				if (line != null) {
					output.append(line);
					output.append('\n');
					
					//View must be updated from the ui thread
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
	
	/**
	 * Gets whether or not the script has finished running.
	 * @return True if the script has finished
	 */
	public boolean isFinished() {
		return finished;
	}
}
