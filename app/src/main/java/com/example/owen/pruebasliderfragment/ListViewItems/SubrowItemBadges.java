package com.example.owen.pruebasliderfragment.ListViewItems;

import java.io.Serializable;

/**
 * Created by Owen on 12/02/2015.
 */
public class SubrowItemBadges implements Serializable {

    private int badgeImage;
    private String badgeText;
    private String badgeTitle;

    public SubrowItemBadges(int image, String text, String title){
        badgeImage = image;
        badgeText = text;
        badgeTitle = title;
    }

    public void setBadgeText(String text){
        badgeText = text;
    }

    public void setBadgeImage(int image){
        badgeImage = image;
    }

    public void setBadgeTitle(String title){ badgeTitle = title; }

    public String getBadgeText(){
        return badgeText;
    }

    public int getBadgeImage(){
        return badgeImage;
    }

    public String getBadgeTitle(){ return badgeTitle; }
}
