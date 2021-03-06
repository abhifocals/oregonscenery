package com.ahanda.oregonscenery.retrofit;

import com.ahanda.oregonscenery.rest.FlickrResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrService {

   String KEY = "28d85d74d398b9a17a25899c8b5cb327";

    @GET("rest?method=flickr.photos.getRecent&api_key=" + KEY + "&format=json&nojsoncallback=1&extras=url_s,url_c")
    Call<FlickrResponse> getRecentPhotos();

    @GET("rest?method=flickr.photos.search&api_key=" + KEY + "&format=json&nojsoncallback=1&extras=url_s,url_c")
    Call<FlickrResponse> searchPhotosUsingKeyword(@Query("tags") String keyword);
}
