package com.e.popularmovies;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private moviesAdapter mMoviesAdapter;
    private RecyclerView movieRecyclerView;
    private  moviesRepository moviesRepository;
    private TMDbApi tmDbApi;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "be44f9cb6ab3f64b9c91466c0ce1160c";
    private static final String Language = "en-us";
    private  List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //initializing the recyclerView member variable
        movieRecyclerView = findViewById(R.id.movie_list);

        //create a layout manager for the recycler view
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        movieRecyclerView.setLayoutManager(layoutManager);


        tmDbApi = moviesRepository.getRetrofitInstance().create(TMDbApi.class);

            Call<MoviesResponse> call=tmDbApi.getMovies(1, BASE_URL);
                call.enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        assert response.body() != null;
                        movieList = response.body().getResults();
                            Log.d("Number of movies:", String.valueOf(movieList.size()));
                          // mMoviesAdapter.notifyDataSetChanged();
                            mMoviesAdapter =new moviesAdapter(movieList, MainActivity.this);
                            movieRecyclerView.setAdapter(mMoviesAdapter);
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
