package com.evanglazer.moviezone.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evanglazer.moviezone.R;
import com.evanglazer.moviezone.model.MovieDetail;

import java.util.List;


/**
 * Created by Evan on 1/3/2016.
 */
public class Detail extends Fragment {
    List<MovieDetail> movieDetails;
    MovieDetail m_movieDetails;

    TextView IMDBRating;
    TextView UserRating;
    TextView ReleaseDate;
    ImageView imageView;
    TextView title;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Intent i = new Intent();
        super.onCreate(savedInstanceState);
        savedInstanceState = i.getExtras();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_detail_fragment, container, false);
        return v;

    }
}
