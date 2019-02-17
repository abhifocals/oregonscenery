package com.ahanda.flickrclientnew.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahanda.flickrclientnew.R;
import com.ahanda.flickrclientnew.rest.Photo;
import com.squareup.picasso.Picasso;

public class PhotoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.single_photo);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        Photo photo = (Photo) bundle.get("currentPhoto");
        ImageView imageView = findViewById(R.id.singlePhoto);

        Picasso.get().load(photo.urls).into(imageView);
    }


}