package com.evanglazer.moviezone.model;

import android.graphics.Bitmap;

/**
 * Created by Evan on 1/6/2016.
 */
public class MovieDetail {

    private String poster_path;
    private String release_date;
    private int id;
    private String original_title;
    private double vote_average;
    private int gridPos;
    private Bitmap bitmap;


    public int getGridPos() {
        return gridPos;
    }

    public void setGridPos(int gridPos) {
        this.gridPos = gridPos;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


}
