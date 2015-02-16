package com.example.owen.pruebasliderfragment.ListViewItems;

/**
 * Created by Owen on 01/02/2015.
 */
public class RowItemSearchCourses {
    private int imageId;
    private String title;
    SubrowItemSearchCourses child = null;


    public RowItemSearchCourses(int imageId, String title, SubrowItemSearchCourses child) {
        this.imageId = imageId;
        this.title = title;
        this.child = child;
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
    public SubrowItemSearchCourses getChild() {
        return child;
    }

    @Override
    public String toString() {
        return title;
    }
}
