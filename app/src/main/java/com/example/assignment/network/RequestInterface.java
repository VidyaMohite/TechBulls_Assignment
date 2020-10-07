package com.example.assignment.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @Expose
    @SerializedName("Search")
    String id = null;

    @GET("Search")
    Call<JSONResponse> getJSON();
}
