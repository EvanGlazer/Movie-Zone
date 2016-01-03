package com.evanglazer.moviezone;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Evan on 12/30/2015.
 */

public class NavBar extends Fragment implements OnClickListener {
    ImageButton top25;
    ImageButton home;
    ImageButton favorites;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.nav_action_fragment, container, false);
        top25 = (ImageButton) v.findViewById(R.id.top25);

        top25.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(),"HH", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        top25 = (ImageButton) top25.findViewById(R.id.top25);
        Toast.makeText(getActivity(), "HH", Toast.LENGTH_LONG).show();
    }
}
