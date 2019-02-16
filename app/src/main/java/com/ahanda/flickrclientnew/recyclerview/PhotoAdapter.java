package com.ahanda.flickrclientnew.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahanda.flickrclientnew.R;
import com.ahanda.flickrclientnew.rest.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    LayoutInflater layoutInflater;
    List<Photo> photos;

    public PhotoAdapter(Context context, List<Photo> newPhotos) {
        layoutInflater = LayoutInflater.from(context);
        photos = newPhotos;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.photo_recycler, viewGroup, false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder viewHolder, int i) {
        Photo photo = photos.get(i);
        Picasso.get().load(photo.urls).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
