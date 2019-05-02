package com.ahanda.oregonscenery.events;

import com.ahanda.oregonscenery.rest.FlickrResponse;

import lombok.Getter;


@Getter



public class FlickResponseEvent {

    FlickrResponse flickrResponse;

    public FlickResponseEvent(FlickrResponse newFlickrResponse) {
        this.flickrResponse = newFlickrResponse;
    }



}
