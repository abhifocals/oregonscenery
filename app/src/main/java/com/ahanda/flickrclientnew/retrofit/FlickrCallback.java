package com.ahanda.flickrclientnew.retrofit;

import android.util.Log;

import com.ahanda.flickrclientnew.events.FlickResponseEvent;
import com.ahanda.flickrclientnew.rest.FlickrResponse;
import com.ahanda.flickrclientnew.rest.Photo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrCallback implements Callback<FlickrResponse> {

    @Override
    public void onResponse(Call<FlickrResponse> call, Response<FlickrResponse> response) {
        Log.d("Flickr", "Successfully connected");

        int count = response.body().photos.getPhoto().size();


        System.out.println();

//        EventBus.getDefault().post(new FlickResponseEvent(response.body()));

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.d("Flickr", "Connection not succcessful");
    }


}
