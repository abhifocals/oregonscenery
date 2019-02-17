package com.ahanda.flickrclientnew.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ahanda.flickrclientnew.R;
import com.ahanda.flickrclientnew.activity.PhotoActivity;
import com.ahanda.flickrclientnew.events.PhotoClickEvent;
import com.ahanda.flickrclientnew.rest.Photo;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    Photo photo;


    public PhotoViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(this);
    }

    // This is just a method to connect ViewHolder to Adapter
    public void loadImage(Photo newPhoto) {
        photo = newPhoto;

        Picasso.get().load(photo.urls).into(imageView);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), PhotoActivity.class);
        intent.putExtra("currentPhoto", photo);

        view.getContext().startActivity(intent);
    }
}
