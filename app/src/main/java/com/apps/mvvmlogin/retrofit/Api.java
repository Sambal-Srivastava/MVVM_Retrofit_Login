package com.apps.mvvmlogin.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {


    private static final String BASE_URL = "https://baseUrl/dev/translator/api/Mobileapi/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        // change your base URL
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
