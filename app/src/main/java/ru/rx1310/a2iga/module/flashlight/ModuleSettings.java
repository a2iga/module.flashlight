package ru.rx1310.a2iga.module.flashlight;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.util.Log;
import ru.rx1310.a2iga.module.flashlight.R;

public class ModuleSettings extends PreferenceActivity {

	Preference p1, p2, p3;
	PreferenceCategory c1;
	
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        PreferenceScreen p = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(p);

        p1 = new Preference(this);
        p1.setEnabled(false);
        p1.setSummary(R.string.pref_module_not_settings);

		c1 = new PreferenceCategory(this);
		c1.setTitle(R.string.pref_category_about);
		
		p2 = new Preference(this);
		p2.setTitle(R.string.pref_module_dev);
		p2.setSummary(R.string.module_dev);
		p2.setKey("MODULE_DEV");
        
		p3 = new Preference(this);
		p3.setTitle(R.string.pref_module_version);
		p3.setSummary(getAppVersion(this));
		p3.setKey("MODULE_VERSION");
		
        p.addPreference(p1);
		p.addPreference(c1);
		p.addPreference(p2);
		p.addPreference(p3);

    }
	
	public boolean onPreferenceTreeClick(PreferenceScreen ps, Preference p) {

        switch (p.getKey()) {

            case "MODULE_DEV":
                Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(getString(R.string.module_dev_link)));
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
                break;

            default: break;

        }

        return super.onPreferenceTreeClick(ps, p);

	}
	
	public static String getAppVersion(Context context) {

		try {

			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);

			String vn = pi.versionName;
			int vc = pi.versionCode;
			
			return vn + "." + vc;

		} catch (Exception exc) {
			exc.printStackTrace();
			return "EC:VNIPN";
		}

	}

}
