package com.evanglazer.moviezone;

import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.evanglazer.moviezone.adapters.MovieDetailAdapter;
import com.evanglazer.moviezone.api.MovieAPI;
import com.evanglazer.moviezone.model.MovieDetail;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by Evan on 1/3/2016.
 */
public class DetailActivity extends ListActivity{

    public static final String URL_IMAGE_ENDPOINT = "http://image.tmdb.org";
    public static final String URL_API_ENDPOINT = "http://api.themoviedb.org";
    FragmentManager fm = getFragmentManager();
    List<MovieDetail> details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);
        //fm.beginTransaction().replace(R.id.main2, new Detail()).commit();
        //fm.beginTransaction().replace(R.id.main2, new NavBar()).commit();

        if (isOnline()) {
            requestData();
        } else {
            Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
        }
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
    private void requestData()
    {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(URL_API_ENDPOINT)
                .build();

        MovieAPI api = adapter.create(MovieAPI.class);

        api.getMovieDetails(new Callback<List<MovieDetail>>() {
            @Override
            public void success(List<MovieDetail> movieDetails, Response response) {
                details = movieDetails;
                // update display
                updateDisplay();
            }

            @Override
            public void failure(RetrofitError arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    protected void updateDisplay() {
        //Use FlowerAdapter to display data
        MovieDetailAdapter adapter = new MovieDetailAdapter(this, R.layout.movie_detail_fragment, details);
        setListAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
