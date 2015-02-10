package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 01/02/2015.
 */
public class RowItem {
    private int imageId;
    private String title;
    private String answer;
    public RowItem(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public RowItem(int imageId, String title, String answer) {
        this.imageId = imageId;
        this.title = title;
        this.answer = answer;
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
    public String getAnswer(){ return answer; }
    public void setAnswer(String answer){ this.answer = answer; }
    @Override
    public String toString() {
        return title;
    }
}
