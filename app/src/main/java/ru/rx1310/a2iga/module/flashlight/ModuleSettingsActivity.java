package ru.rx1310.a2iga.module.flashlight;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import ru.rx1310.a2iga.module.flashlight.R;

public class ModuleSettingsActivity extends PreferenceActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setTitle(R.string.activity_settings);

        PreferenceScreen p = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(p);

        Preference a = new Preference(this);
        a.setEnabled(false);
        a.setSummary(R.string.settings_not_available);

        
        p.addPreference(a);

    }

}
