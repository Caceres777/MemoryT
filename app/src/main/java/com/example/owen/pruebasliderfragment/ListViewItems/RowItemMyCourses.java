package com.example.owen.pruebasliderfragment.ListViewItems;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Owen on 18/02/2015.
 */
public class RowItemMyCourses implements Serializable {
    private Bitmap imageId;
    private String title;
    private int progress;
    SubrowItemMyCourses child = null;


    public RowItemMyCourses(Bitmap imageId, String title, SubrowItemMyCourses child, int progress) {
        this.imageId = imageId;
        this.title = title;
        this.child = child;
        this.progress = progress;

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
    public SubrowItemMyCourses getChild() {
        return child;
    }
    public int getProgress() {
        return progress;
    }
    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return title;
    }
}
