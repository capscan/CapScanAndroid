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

public class CaptureImage extends Activity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagecapture);
		
		if(isIntentAvailable(this, "MediaStore.ACTION_IMAGE_CAPTURE")) {
			dispatchTakePictureIntent();
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
	
	private void handleSmallCameraPhoto(Intent intent) {
	    Bundle extras = intent.getExtras();
	    Bitmap mImageBitmap = (Bitmap) extras.get("data");
	    mImageView.setImageBitmap(mImageBitmap);
	}
}