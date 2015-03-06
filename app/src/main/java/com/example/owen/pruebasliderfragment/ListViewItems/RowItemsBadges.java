package com.example.owen.pruebasliderfragment.ListViewItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owen on 12/02/2015.
 */
public class RowItemsBadges implements Serializable {
    public String title;
    public int title_img;
    public final List<SubrowItemBadges> children = new ArrayList<SubrowItemBadges>();


    public RowItemsBadges(int title_img, String title) {
        this.title = title;
        this.title_img = title_img;
    }

}
