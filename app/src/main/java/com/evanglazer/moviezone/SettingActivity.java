package com.evanglazer.moviezone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by Evan on 1/3/2016.
 */
public class SettingActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    Switch switchFav;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //addPreferencesFromResource(R.xml.prefs);
        setContentView(R.layout.setting_layout);
        switchFav = (Switch) findViewById(R.id.switchfav);
        switchFav.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == false)
        {
            Toast.makeText(getApplicationContext(), "You have chosen to not save your movies!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "You have enabled saving your movies!", Toast.LENGTH_LONG).show();
        }
    }
}
