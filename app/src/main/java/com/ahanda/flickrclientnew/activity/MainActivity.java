package com.ahanda.flickrclientnew.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ahanda.flickrclientnew.R;
import com.ahanda.flickrclientnew.events.FlickResponseEvent;
import com.ahanda.flickrclientnew.fragment.FragmentController;
import com.ahanda.flickrclientnew.recyclerview.PhotoAdapter;
import com.ahanda.flickrclientnew.rest.FlickrResponse;
import com.ahanda.flickrclientnew.retrofit.FlickrCallback;
import com.ahanda.flickrclientnew.retrofit.FlickrService;
import com.ahanda.flickrclientnew.retrofit.RetrofitBuilder;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends Activity {

    FlickrCallback callback;
    public static ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, new FragmentController());
        ft.commit();

        // Progress Bar
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

    }
}
