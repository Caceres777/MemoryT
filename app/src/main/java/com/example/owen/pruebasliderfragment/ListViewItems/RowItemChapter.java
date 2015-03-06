package com.example.owen.pruebasliderfragment.ListViewItems;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Owen on 03/03/2015.
 */
public class RowItemChapter implements Serializable {
    private String title;
    private int progress;
    private SubrowItemChapter child = null;


    public RowItemChapter(String title, SubrowItemChapter child, int progress) {
        this.title = title;
        this.child = child;
        this.progress = progress;

    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public SubrowItemChapter getChild() {
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
