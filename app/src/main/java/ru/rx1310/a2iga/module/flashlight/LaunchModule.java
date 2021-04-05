package ru.rx1310.a2iga.module.flashlight;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Toast;

public class LaunchModule extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
		CameraManager cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
		String cID = null;
		
		try { cID = cm.getCameraIdList()[0]; } 
		catch (CameraAccessException e) { e.printStackTrace(); }
		
		final String fcID = cID;

		try { cm.setTorchMode(fcID, true); } 
		catch (CameraAccessException e) { e.printStackTrace(); }
		
		Toast.makeText(this, R.string.flash_on, Toast.LENGTH_LONG).show();
		
		this.finish();

    }
    
}
