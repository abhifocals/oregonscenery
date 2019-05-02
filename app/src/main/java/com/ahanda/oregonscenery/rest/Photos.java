package com.ahanda.oregonscenery.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Photos implements Serializable {

    @Expose
    @SerializedName("page")
    private Integer page;

    @Expose
    @SerializedName("pages")
    private Integer pages;

    @Expose
    @SerializedName("perpage")
    private Integer perpage;

    @Expose
    @SerializedName("total")
    private Integer total;

    public List<Photo> photo = null;
}
