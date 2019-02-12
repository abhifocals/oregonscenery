package com.ahanda.flickrclientnew.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahanda.flickrclientnew.R;
import com.ahanda.flickrclientnew.events.FlickResponseEvent;
import com.ahanda.flickrclientnew.recyclerview.PhotoAdapter;
import com.ahanda.flickrclientnew.rest.FlickrResponse;
import com.ahanda.flickrclientnew.retrofit.FlickrCallback;
import com.ahanda.flickrclientnew.retrofit.FlickrService;
import com.ahanda.flickrclientnew.retrofit.RetrofitBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class FragmentController extends Fragment {

    FlickrCallback callback;
    RecyclerView recyclerView;
    PhotoAdapter photoAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);



        FlickrService service = RetrofitBuilder.newInstance().create(FlickrService.class);
        callback = new FlickrCallback();

        service.getRecentPhotos().enqueue(callback);

        EventBus.getDefault().register(this);


        return inflater.inflate(R.layout.recycler_fragment, container);

    }

    @Subscribe
    public void getResponse(FlickResponseEvent flickResponseEvent) {
        FlickrResponse flickrResponse = flickResponseEvent.getFlickrResponse();


        // Set-up recycler view
        photoAdapter = new PhotoAdapter(getContext(), flickrResponse.photos.photo);
        recyclerView = findViewById(R.id.testing);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(photoAdapter);
    }





}
