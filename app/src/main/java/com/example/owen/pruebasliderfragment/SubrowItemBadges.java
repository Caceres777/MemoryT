package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 12/02/2015.
 */
public class SubrowItemBadges {

    private int badgeImage;
    private String badgeText;

    public SubrowItemBadges(int image, String text){
        badgeImage = image;
        badgeText = text;
    }

    public void setBadgeText(String text){
        badgeText = text;
    }

    public void setBadgeImage(int image){
        badgeImage = image;
    }

    public String getBadgeText(){
        return badgeText;
    }

    public int getBadgeImage(){
        return badgeImage;
    }
}
