package com.example.owen.pruebasliderfragment.ListViewItems;

/**
 * Created by Owen on 18/02/2015.
 */
public class RowItemMyCourses {
    private int imageId;
    private String title;
    private int progress;
    SubrowItemMyCourses child = null;


    public RowItemMyCourses(int imageId, String title, SubrowItemMyCourses child, int progress) {
        this.imageId = imageId;
        this.title = title;
        this.child = child;
        this.progress = progress;

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
