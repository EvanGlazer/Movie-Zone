package com.evanglazer.moviezone;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Evan on 12/30/2015.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NavBar extends Fragment {
    ImageButton top25;
    ImageButton home;
    ImageButton featured;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.nav_action_fragment, container, false);
        return v;
    }
}
