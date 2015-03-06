package com.example.owen.pruebasliderfragment.ListViewItems;

import java.io.Serializable;

/**
 * Created by Owen on 01/02/2015.
 */
public class RowItemMenu implements Serializable {
    private int imageId;
    private String title;

    public RowItemMenu(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }


    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return title;
    }
}
