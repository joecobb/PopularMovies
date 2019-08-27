package com.e.popularmovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieGenre(List<Integer> movieGenre) {
        this.movieGenre = movieGenre;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @SerializedName("id")
        private int id;

        @SerializedName("genre_ids")
        private List<Integer> movieGenre;

        @SerializedName("release_date")
        private String movieYear;

        @SerializedName("original_title")
        private String movieTitle;

    public String getPosterPath() {
        return posterPath;
    }

    @SerializedName("poster_path")
        private String posterPath;

    public int getId() {
        return id;
    }

    public List<Integer> getMovieGenre() {
        return movieGenre;
    }



    public String getMovieTitle() {
        return movieTitle;
    }



    public String getMovieYear() {
        return movieYear;
    }

}
