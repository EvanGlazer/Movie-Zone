package com.evanglazer.moviezone;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.evanglazer.moviezone.fragments.MovieHome;
import com.evanglazer.moviezone.model.MovieDetail;

import java.util.List;


/**
 * Created by Evan on 1/3/2016.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String URL_IMAGE_ENDPOINT = "http://image.tmdb.org";
    public static final String URL_API_ENDPOINT = "http://api.themoviedb.org";
    FragmentManager fm = getFragmentManager();
    List<MovieDetail> details;
    ListView listView;
    ImageView imageView;
    MovieDetail d;

    TextView IMDBRating;
    TextView UserRating;
    TextView ReleaseDate;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);
        //fm.beginTransaction().replace(R.id.main2, new Detail()).commit();
        //fm.beginTransaction().replace(R.id.main2, new NavBar()).commit();
        listView = (ListView) findViewById(R.id.lv);
        imageView = (ImageView) findViewById(R.id.movieView);
        IMDBRating = (TextView) findViewById(R.id.imdbRatingText);
        UserRating = (TextView) findViewById(R.id.userRatingText);
        ReleaseDate = (TextView) findViewById(R.id.releaseDateText);

        Intent i = getIntent();
        //Getting intent
        Intent intent = getIntent();

        //Displaying values by fetching from intent
        IMDBRating.setText(String.valueOf(intent.getIntExtra(MovieHome.KEY_IMDB_RATING, 0)));
        UserRating.setText(intent.getStringExtra(MovieHome.KEY_USER_RATING));
        ReleaseDate.setText(intent.getStringExtra(MovieHome.KEY_RELEASE_DATE));
        
        //imageView.setImageURI( URL_API_ENDPOINT  );


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
