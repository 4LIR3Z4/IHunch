package ir.alirezab.ihunch.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.preference.PreferenceFragmentCompat;

import ir.alirezab.ihunch.R;

public class SettingsFragment extends PreferenceFragmentCompat {
	private static final String SETTINGS_ID = "Settings";
	private Context ctx;
	
	@Override
	public void onCreatePreferences (Bundle savedInstanceState, String rootKey) {
		
		ctx = getContext ();
		setPreferencesFromResource (R.xml.root_preferences, rootKey);
		try {
			SharedPreferences sharedPreferences = ctx.getSharedPreferences (SETTINGS_ID, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPreferences.edit ();
			editor.putString ("theme", "dark");
			editor.apply ();
			String value = sharedPreferences.getString ("theme", "light");
		} catch (Exception e) {
			Log.d ("ERR_Settings", "onCreatePreferences: " + e.getLocalizedMessage ());
		}
		
	}
}