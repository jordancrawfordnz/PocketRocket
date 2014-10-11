package com.sneakyrocket.pocketrocket.v1.core;

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
	}
	
	public Context getApplicationContext() {
		return context;
	}
}
