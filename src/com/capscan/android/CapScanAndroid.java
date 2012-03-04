package com.capscan.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CapScanAndroid extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button takePicButton = (Button) findViewById(R.id.takepic);
		takePicButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent captureIntent = new Intent("BottleCapCapture");
				startActivity(captureIntent);
			}
		});

	}
}