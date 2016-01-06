package com.evanglazer.moviezone.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.evanglazer.moviezone.DetailActivity;
import com.evanglazer.moviezone.R;
import com.evanglazer.moviezone.model.MovieDetail;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by Evan on 1/6/2016.
 */
public class MovieDetailAdapter extends ArrayAdapter<MovieDetail> {
    private Context mContext;
    private List<MovieDetail> movieDetail;
    private int width;

    LruCache<Integer, Bitmap> imageCache;

    private TextView IMDBVote;
    private TextView UserVote;
    private TextView ReleaseDate;


    public MovieDetailAdapter(Context context, int resource, List<MovieDetail> objects) {
        super(context, resource, objects);
        mContext = context;
        width = resource;
        movieDetail = objects;

        // LRU Cache
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory() /1024);
        final int cacheSize = maxMemory / 8;
        imageCache = new LruCache<Integer, Bitmap>(cacheSize);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.movie_detail_fragment, parent, false);

        //Display Movie info in the TextView widget
        MovieDetail m_MovieDetail = movieDetail.get(position);
        IMDBVote = (TextView) view.findViewById(R.id.imdbRatingText);
        UserVote = (TextView) view.findViewById(R.id.userRatingText);
        ReleaseDate = (TextView) view.findViewById(R.id.releaseDateText);

        IMDBVote.setText(String.valueOf(m_MovieDetail.getVote_average()));
        UserVote.setText(String.valueOf(m_MovieDetail.getVote_average()));
        ReleaseDate.setText(m_MovieDetail.getRelease_date());

        //Display movie photo in ImageView widget
        Bitmap bitmap = imageCache.get(m_MovieDetail.getId());
        if (bitmap != null) {
            MovieDetail detail = movieDetail.get(position);
            ImageView image = (ImageView) view.findViewById(R.id.movieView);
            image.setImageBitmap(detail.getPoster_path());
        }
        else {

            MovieView container = new MovieView();
            container.detail = m_MovieDetail;
            container.view = view;

            ImageLoader loader = new ImageLoader();
            loader.execute(container);
        }

        return view;
    }

    class MovieView {
        public MovieDetail detail;
        public View view;
        public Bitmap bitmap;
    }

    private class ImageLoader extends AsyncTask<MovieView, Void, MovieView> {

        @Override
        protected MovieView doInBackground(MovieView... params) {

            MovieView container = params[0];
            MovieDetail detail = container.detail;

            try {
                String imageUrl = DetailActivity.URL_IMAGE + detail.getGridPos();
                InputStream in = (InputStream) new URL(imageUrl).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                detail.setPoster_path(bitmap);
                in.close();
                container.bitmap = bitmap;
                return container;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(MovieView result) {
            ImageView image = (ImageView) result.view.findViewById(R.id.movieView);
            image.setImageBitmap(result.bitmap);
            imageCache.put(result.detail.getId(), result.bitmap);
        }

    }


}
