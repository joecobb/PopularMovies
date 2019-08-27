package com.e.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class moviesAdapter extends RecyclerView.Adapter<moviesAdapter.movieViewHolder>  {
    private ImageView movieImage;
    private TextView movieTitle, movieGenre, movieYear, movieRating;
    private List<Movie> movies;
    private Context context;

    public moviesAdapter(List<Movie> moviesList, Context context){
        this.movies = moviesList;
        this.context = context;
    }



    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =  parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_layout, parent, false);


        return new movieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
         return movies.size();

    }

    //create inner viewHolder class
    public class movieViewHolder extends RecyclerView.ViewHolder{



        public movieViewHolder(@NonNull View itemView) {
            super(itemView);
            //get the itemView ids here
            movieImage = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieGenre = itemView.findViewById(R.id.movie_genre);
            movieYear = itemView.findViewById(R.id.movie_year);

        }

        public void bind(Movie movie){
            movieTitle.setText(movie.getMovieTitle());
            movieGenre.setText("");
            movieYear.setText(movie.getMovieYear());
//            movieRating.setText("");
        }
    }
}