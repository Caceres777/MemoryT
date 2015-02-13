package com.example.owen.pruebasliderfragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 12/02/2015.
 */
public class RowItemsBadges {
    public String title;
    public int title_img;
    public final List<SubrowItemBadges> children = new ArrayList<SubrowItemBadges>();


    public RowItemsBadges(int title_img, String title) {
        this.title = title;
        this.title_img = title_img;
    }

}
