package com.evanglazer.moviezone.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evanglazer.moviezone.R;
import com.evanglazer.moviezone.model.MovieDetail;

import java.util.List;

/**
 * Created by Evan on 1/3/2016.
 */
public class Detail extends Fragment {
    List<MovieDetail> movieDetails;
    MovieDetail m_movieDetails;

    @Override
    public void onStart() {
        super.onStart();
        // position of onclick listener for the gridview in MovieHome will be stored in here
       // m_movieDetails = movieDetails.get(m_movieDetails.getGridPos());
       // getActivity().setTitle("           "+ m_movieDetails.getOriginal_title());
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_detail_fragment, container, false);
        return v;

    }
}
