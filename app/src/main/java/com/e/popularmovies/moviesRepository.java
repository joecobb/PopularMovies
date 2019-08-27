package com.e.popularmovies;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

public class moviesRepository {

    private moviesAdapter Adapter;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "be44f9cb6ab3f64b9c91466c0ce1160c";
    private static final String Language = "en-us";

    public static Retrofit getRetrofitInstance() {

            Retrofit retrofit  = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    return retrofit;
    }
/*
    public moviesAdapter getMovies( ){

        api.getMovies(1,API_KEY)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response)
                    {

                    }
                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        String message=t.getMessage();
                    }
                });


return Adapter;
    }

    */
}
