package com.example.assignment.network;

import com.example.assignment.model.MovieData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RequestInterface {
   /* @GET("http://www.omdbapi.com/?")
    Call<List<MovieData>> getMovieData(@Query("s") String movie, @Query("apikey") String apikey);*/

    @GET()
    Call<MovieData> getMovieData(@Url String url);
}
