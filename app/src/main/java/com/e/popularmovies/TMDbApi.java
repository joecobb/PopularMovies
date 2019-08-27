package com.e.popularmovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDbApi {

    @GET("movie/popular")
    Call<MoviesResponse> getMovies(
            @Query("page") int page,
            @Query("api_key") String apiKey
    );
    }




