package ru.rx1310.a2iga.module.flashlight;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ModuleLaunch extends Activity {

	boolean isFlashEnabled;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
		isFlashEnabled = getBooleanData(this, "isFlashEnabled");
		
		CameraManager cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
		String cID = null;
		
		try { cID = cm.getCameraIdList()[0]; } 
		catch (CameraAccessException e) { e.printStackTrace(); }
		
		final String fcID = cID;

		try {
			
			if (isFlashEnabled) {
				cm.setTorchMode(fcID, false); 
				changeState(false, getString(R.string.flash_off));
			} else if (!isFlashEnabled) {
				cm.setTorchMode(fcID, true); 
				changeState(true, getString(R.string.flash_on));
			} else {
				cm.setTorchMode(fcID, false); 
				changeState(false, getString(R.string.flash_off));
			}
			
		} catch (CameraAccessException e) { 
			e.printStackTrace(); 
		}
		
		this.finish();

    }
	
	void changeState(boolean flashState, String toastMsg) {
		saveData(this, "isFlashEnabled", flashState);
		Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
	}
	
	boolean getBooleanData(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false);
    }
	
	void saveData(Context context, String key, boolean val) {
        PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putBoolean(key, val)
            .apply();
    }

    void saveData(Editor editor) {
        editor.apply();
    }
    
}
