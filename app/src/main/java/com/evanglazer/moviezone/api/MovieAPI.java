package com.evanglazer.moviezone.api;

import com.evanglazer.moviezone.model.MovieDetail;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Evan on 1/5/2016.
 */
public interface MovieAPI {

    @GET("/3/movie/273248?api_key=ea8f68dc2c7b43a3df248b9a638f5fb4")
    void getMovieDetails(Callback<List<MovieDetail>> callback);

    @GET("3/movie/5493/movie/549")
    void getPopularMovies(Callback<List<MovieDetail>> response);




}
