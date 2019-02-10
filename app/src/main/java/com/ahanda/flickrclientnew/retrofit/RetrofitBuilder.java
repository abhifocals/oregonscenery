package com.ahanda.flickrclientnew.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {


    public static Retrofit newInstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/").addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }

}
