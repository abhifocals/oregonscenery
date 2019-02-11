package com.ahanda.flickrclientnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.ahanda.flickrclientnew.events.FlickResponseEvent;
import com.ahanda.flickrclientnew.recyclerview.PhotoAdapter;
import com.ahanda.flickrclientnew.rest.FlickrResponse;
import com.ahanda.flickrclientnew.retrofit.FlickrCallback;
import com.ahanda.flickrclientnew.retrofit.FlickrService;
import com.ahanda.flickrclientnew.retrofit.RetrofitBuilder;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    FlickrCallback callback;
    RecyclerView recyclerView;
    PhotoAdapter photoAdapter;

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


        // Set-up recycler view
        photoAdapter = new PhotoAdapter(getApplicationContext(), flickrResponse.photos.photo);
        recyclerView = findViewById(R.id.testing);

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(photoAdapter);
    }
}
