package com.example.assignment.network;
/*
 * Dev - Vidya Jadav - 07/10/2020
 * */
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetofitClient {

    private static RetofitClient instance = null;
    private RequestInterface myApi;
    public static final String BASE_URL = "http://www.omdbapi.com/";


    private RetofitClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        myApi = retrofit.create(RequestInterface.class);
    }

    public static synchronized RetofitClient getInstance() {
        if (instance == null) {
            instance = new RetofitClient();
        }
        return instance;
    }

    public RequestInterface getMyApi() {
        return myApi;
    }
}
