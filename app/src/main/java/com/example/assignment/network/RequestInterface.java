package com.example.assignment.network;
/*
 * Dev - Vidya Jadav - 07/10/2020
 * */
import com.example.assignment.model.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RequestInterface {
    @GET("http://www.omdbapi.com/?")
    Call<Search> getMovieData(@Query("s") String movie, @Query("apikey") String apikey);

   /* @GET()
    Call<Search> getMovieData(@Url String url);*/
}
