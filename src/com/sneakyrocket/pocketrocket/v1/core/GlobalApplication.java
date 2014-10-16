package com.sneakyrocket.pocketrocket.v1.core;

import android.app.Application;
import android.content.Context;

/**
 * A class to provide global and controlled access to the application and
 * its corresponding functionality. A single instance is created when the
 * app is launched, and can be accessed through static methods.
 * @author Andrew
 *
 */
public class GlobalApplication extends Application {
	private static GlobalApplication singleton;
	
	private Context context;
	
	/**
	 * Gets the instance of GlobalApplication
	 * @return the GloablApplication
	 */
	public static GlobalApplication getInstance() {
		if (singleton == null)
			throw new IllegalStateException();
		return singleton;
	}
 
	@Override
	/**
	 * Performs the original functionality, and sets this instance to be
	 * the singleton
	 */
	public void onCreate() {
		super.onCreate();
		singleton = this;
		context = getApplicationContext();
	}
	
	/**
	 * Gets the application context from the current application.
	 * @return the application context
	 */
	public Context getApplicationContext() {
		return context;
	}
}
