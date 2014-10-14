package com.sneakyrocket.pocketrocket.v1.core.response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import android.util.Log;

import com.sneakyrocket.pocketrocket.R;
import com.sneakyrocket.pocketrocket.v1.core.Connection;
import com.sneakyrocket.pocketrocket.v1.core.GlobalApplication;

public class OkText extends Response {
	private BufferedReader reader;
	private PipedReader pipedReader;
	private PipedWriter pipedWriter;
	
	public OkText(String args, Connection connection)
	{
		super(args, connection);
		pipedReader = new PipedReader();
		reader = new BufferedReader(pipedReader);
	}

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
	
	public BufferedReader getReader() {
		return reader;
	}
}
