package com.evanglazer.moviezone.api;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by Evan on 1/5/2016.
 */
public interface MovieAPI {

    //http://image.tmdb.org
    @GET("/t/p/w185/")
    public void getMovieImage(Callback<String> response);

    @GET("3/movie/5493/movie/549")
    public void getPopularMovies(Callback<String> response);
}
