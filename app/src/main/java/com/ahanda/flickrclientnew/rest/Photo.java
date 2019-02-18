package com.ahanda.flickrclientnew.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Photo implements Serializable {

    @Expose
    @SerializedName("id")
    public String id;

    @Expose
    @SerializedName("title")
    public String title;

    @Expose
    @SerializedName("owner")
    public String owner;

    @Expose
    @SerializedName("secret")
    public String secret;

    @Expose
    @SerializedName("server")
    public String server;

    @Expose
    @SerializedName("farm")
    public String farm;

    @Expose
    @SerializedName("url_s")
    public String urls;

    @Expose
    @SerializedName("url_c")
    public String urlc;
}
