package com.ahanda.oregonscenery.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.ahanda.oregonscenery.R;
import com.ahanda.oregonscenery.fragment.FragmentController;
import com.ahanda.oregonscenery.retrofit.FlickrCallback;

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
