package com.ahanda.flickrclientnew.events;

import com.ahanda.flickrclientnew.rest.Photo;

import lombok.Getter;

@Getter


public class PhotoClickEvent {

    Photo photo;

    public PhotoClickEvent(Photo newPhoto) {
        this.photo = newPhoto;
    }


}
