package com.ahanda.flickrclientnew.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ahanda.flickrclientnew.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
