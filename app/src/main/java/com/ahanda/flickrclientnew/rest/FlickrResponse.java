package com.ahanda.flickrclientnew.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlickrResponse implements Serializable {


    @Expose
    @SerializedName("photos")
    public Photos photos;
}
