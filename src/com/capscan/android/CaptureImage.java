package com.capscan.android;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CaptureImage extends Activity {

	ImageView img = (ImageView) findViewById(R.id.imgview);
	private static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 555;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagecapture);

		Button takePicButton = (Button) findViewById(R.id.capImgButton);
		takePicButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
				//					startActivityForResult(takePictureIntent, 1);
				startActivityForResult(takePictureIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			}
		});

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if(resultCode == RESULT_OK) {
				Bundle extras = data.getExtras();
				Bitmap mImageBitmap = (Bitmap) extras.get("data");
				img.setImageBitmap(mImageBitmap);
			}
			else {
				Toast.makeText(this, "Image Capture Failed", Toast.LENGTH_LONG).show();
			}
		}
	}

	public static boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list =
				packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}

	private void dispatchTakePictureIntent(int actionCode) {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(takePictureIntent, actionCode);
	}
}