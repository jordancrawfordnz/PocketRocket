package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import android.util.Log;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;

/**
 * Provides output to a BufferedReader. When a ESC character is received, finishes and allows other responses to be handled.
 * @author Jordan Crawford
 *
 */
public class OkText extends Response {
	private BufferedReader reader;
	private PipedReader pipedReader;
	private PipedWriter pipedWriter;
	
	/**
	 * Creates the piped reader and the BufferedReader to be returned.
	 * The BufferedReader buffers the pipedReader (so output in the piped reader show in the buffered reader).
	 * @param args
	 * @param connection
	 */
	public OkText(String args, Connection connection)
	{
		super(args, connection);
		pipedReader = new PipedReader();
		reader = new BufferedReader(pipedReader);
	}

	/**
	 * Creates the piped writer and links it to the piped reader.
	 * This means any content written to the piped writer will appear on the piped reader
	 * and hence in the returned buffered reader.
	 * Reads the incoming network stream character by character until the ESC character (ASCII 27) is received.
	 */
	@Override
	public void process() {
		try {
			BufferedReader incoming = connection.getNetworkInput();
			pipedWriter = new PipedWriter(pipedReader);
			
			while(true)
			{
				int incomingChar = incoming.read();
				if(incomingChar == 27) break;
				pipedWriter.write(incomingChar);
			}
			pipedWriter.close();
		} catch (IOException e) {
			Log.d(GlobalApplication.getInstance().getResources()
					.getString(R.string.app_name), e.getMessage());
			throw new ResponseFailureException();
		}
		super.process();
	}
	
	/**
	 * Gets the reader containing response output.
	 * @return
	 */
	public BufferedReader getReader() {
		return reader;
	}
}
