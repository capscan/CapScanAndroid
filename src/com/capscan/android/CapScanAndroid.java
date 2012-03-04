package com.capscan.android;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;

public class CapScanAndroid extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Camera camera = Camera.open();
		
		if(camera == null) {
			
		}
	}
}