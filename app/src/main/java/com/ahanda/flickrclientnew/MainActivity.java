package com.ahanda.flickrclientnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ahanda.flickrclientnew.events.FlickResponseEvent;
import com.ahanda.flickrclientnew.rest.FlickrResponse;
import com.ahanda.flickrclientnew.retrofit.FlickrCallback;
import com.ahanda.flickrclientnew.retrofit.FlickrService;
import com.ahanda.flickrclientnew.retrofit.RetrofitBuilder;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    FlickrCallback callback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlickrService service = RetrofitBuilder.newInstance().create(FlickrService.class);
        callback = new FlickrCallback();

        service.getRecentPhotos().enqueue(callback);

        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }



    @Subscribe
    public void getResponse(FlickResponseEvent flickResponseEvent) {
        FlickrResponse flickrResponse = flickResponseEvent.getFlickrResponse();


        ImageView imageView = findViewById(R.id.imageView);

        try {
            Picasso.get().load(flickrResponse.photos.photo.get(0).urls).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
