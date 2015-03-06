package com.example.owen.pruebasliderfragment.ListViewItems;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Owen on 01/02/2015.
 */
public class RowItemSearchCourses implements Serializable {
    private Bitmap imageId;
    private String title;
    SubrowItemSearchCourses child = null;


    public RowItemSearchCourses(Bitmap imageId, String title, SubrowItemSearchCourses child) {
        this.imageId = imageId;
        this.title = title;
        this.child = child;
    }

    public Bitmap getImageId() {
        return imageId;
    }
    public void setImageId(Bitmap imageId) {
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public SubrowItemSearchCourses getChild() {
        return child;
    }

    @Override
    public String toString() {
        return title;
    }
}
