package com.example.owen.pruebasliderfragment.data.DataEntry;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public abstract class BadgesEntry implements Serializable {
    //        public static final String COLUMN_ID = BaseColumns._ID;
    public static final String TABLE_NAME = "BADGES";
    public static final String ID_BADGE = "id_badge";
    public static final String FK_ID_COURSE = "fk_id_course";
    public static final Bitmap IMAGE= null;
    public static final String TITLE = "title";
    public static final String TEXT = "text";

    @Override
    public String toString() {
        return "BadgesEntry{" +
                "BADGES='" + TABLE_NAME + '\'' +
                ", ID_BADGE='" + ID_BADGE + '\'' +
                ", FK_ID_COURSE='" + FK_ID_COURSE + '\'' +
                ", IMAGE='" + IMAGE + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", TEXT='" + TEXT + '\'' +
                '}';
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdBadge() {
        return ID_BADGE;
    }

    public String getFkIdCourse() {
        return FK_ID_COURSE;
    }

    public Bitmap getImage() {
        return IMAGE;
    }

    public String getTitle() {
        return TITLE;
    }

    public String getText() {
        return TEXT;
    }

}
