package com.sneakyrocket.pocketrocket.v1.core;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import com.sneakyrocket.pocketrocket.v1.core.response.ResponseHandler;

import android.app.Application;
import android.content.Context;

public class GlobalApplication extends Application {
	private static GlobalApplication singleton;
	
	private Context context;
	
	public static GlobalApplication getInstance() {
		if (singleton == null)
			throw new IllegalStateException();
		return singleton;
	}
 
	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		context = getApplicationContext();
		
		// This would usually be coming from a Command.
		try
		{
			InetAddress myComputer = InetAddress.getByName("192.168.1.101");
			Socket testingOutput = new Socket(myComputer,5050);
			Connection fakeServer = new Connection(myComputer,2359);
			fakeServer.sendRequest("hello");
			ResponseHandler response = fakeServer.getResponseHandler();
			InputStream commandResponse =  response.getResponse();
			copyFile(commandResponse,testingOutput.getOutputStream());
		}
		catch(Exception ex)
		{
			System.err.println(ex.toString());
		}
	}
	
	
	public static void copyFile(InputStream in, OutputStream out) {
		try {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (IOException e){
			System.err.println("File copy failed: " + e );
		}
	} //copyFile()
	
	public Context getApplicationContext() {
		return context;
	}
}
