package com.evanglazer.moviezone;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Evan on 12/30/2015.
 */
public class MovieDetail extends Fragment{
    static GridView gridView;
    static int width;
    static ArrayList<String> posters;
    static boolean sortByPop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.movie_detail_fragment, container, false);

        WindowManager wm = (WindowManager) getActivity().getSystemService((Context.WINDOW_SERVICE));
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // change display for tablet and phone 1/6 or 1/3
        if(MainActivity.TABLET)
        {
            width = size.x/6;
        }
        else width = size.x/3;

        // populate 3 posters in a row
        if(getActivity() != null)
        {
            ArrayList<String> array = new ArrayList<String>();
            ImageAdapter adapter = new ImageAdapter(getActivity(), array, width);
            gridView = (GridView) v.findViewById(R.id.gridView);
            // 3 per row
            gridView.setColumnWidth(width);
            gridView.setAdapter(adapter);
        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
            }
        });
        return v;
    }
    public class ImageLoadTask extends AsyncTask<Void, Void, ArrayList<String>>
    {
        // array list will hold strings of image paths
        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            while(true)
            {
                try{
                    posters = new ArrayList(Arrays.asList(getPathsFromAPI(sortByPop)));
                    return posters;
                }
                catch(Exception e){
                    continue;
            }
        }
    }
        public String[] getPathsFromAPI(boolean sort)
        {
            String[] array = new String[15];
            for(int i = 0; i<array.length; i++)
            {
                array[i] = "/path.jpg";
            }
            return array;

        }
    }

    @Override
    public void onStart()
    {
        super.onStart();
        getActivity().setTitle("Top Movies");

        // check if network is available
        if(isNetworkAvailable())
        {
            gridView.setVisibility(GridView.VISIBLE);
            new ImageLoadTask().execute();
        }
        else
        {
            Toast.makeText(getActivity(), "There is no internet connection!", Toast.LENGTH_LONG).show();
            // gridview visibility gone
            gridView.setVisibility(GridView.GONE);
        }
    }

    // check network
    public boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE )
        NetworkInfo activeNetworkInfo =  connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
