package com.ahanda.flickrclientnew.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

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
