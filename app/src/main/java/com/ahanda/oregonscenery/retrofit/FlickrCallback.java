package com.ahanda.oregonscenery.retrofit;

import android.util.Log;

import com.ahanda.oregonscenery.events.FlickResponseEvent;
import com.ahanda.oregonscenery.rest.FlickrResponse;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrCallback implements Callback<FlickrResponse> {

    @Override
    public void onResponse(Call<FlickrResponse> call, Response<FlickrResponse> response) {
        Log.d("Flickr", "Successfully connected");

        int count = response.body().photos.photo.size();

        EventBus.getDefault().post(new FlickResponseEvent(response.body()));

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.d("Flickr", "Connection not succcessful");
    }


}
