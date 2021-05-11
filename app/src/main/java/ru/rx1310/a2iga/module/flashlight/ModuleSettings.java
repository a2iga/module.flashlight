package ru.rx1310.a2iga.module.flashlight;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import ru.rx1310.a2iga.module.flashlight.R;

public class ModuleSettings extends PreferenceActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        PreferenceScreen p = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(p);

        Preference p1 = new Preference(this);
        p1.setEnabled(false);
        p1.setSummary(R.string.msg_no_settings);

		Preference p2 = new Preference(this);
		p2.setTitle(R.string.pref_module_dev);
		p2.setSummary(R.string.module_dev);
		p2.setKey("MODULE_DEV");
        
        p.addPreference(p1);
		p.addPreference(p2);

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

}
