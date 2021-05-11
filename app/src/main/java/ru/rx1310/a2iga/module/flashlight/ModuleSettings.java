package ru.rx1310.a2iga.module.flashlight;

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

        Preference a = new Preference(this);
        a.setEnabled(false);
        a.setSummary(R.string.msg_no_settings);

        
        p.addPreference(a);

    }

}
