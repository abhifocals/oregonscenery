package com.ahanda.flickrclientnew.events;

import com.ahanda.flickrclientnew.rest.FlickrResponse;

import lombok.Getter;


@Getter



public class FlickResponseEvent {

    FlickrResponse flickrResponse;

    public FlickResponseEvent(FlickrResponse newFlickrResponse) {
        this.flickrResponse = newFlickrResponse;
    }



}
