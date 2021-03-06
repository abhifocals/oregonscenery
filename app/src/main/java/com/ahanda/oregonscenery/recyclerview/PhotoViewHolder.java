package com.ahanda.oregonscenery.recyclerview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ahanda.oregonscenery.R;
import com.ahanda.oregonscenery.activity.PhotoActivity;
import com.ahanda.oregonscenery.rest.Photo;
import com.squareup.picasso.Picasso;

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

        Picasso.get().load(photo.urlc).into(imageView);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), PhotoActivity.class);
        intent.putExtra("currentPhoto", photo);

        view.getContext().startActivity(intent);
    }
}
