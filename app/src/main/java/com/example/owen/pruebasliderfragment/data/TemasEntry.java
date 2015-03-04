package com.example.owen.pruebasliderfragment.data;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class TemasEntry implements Serializable {
    //        public static final String COLUMN_ID = BaseColumns._ID;
    public static String TABLE_NAME = "TEMAS";
    public static String ID_THEME = "id_theme";
    public static String FK_ID_COURSE = "fk_id_course";
    public static String NAME = "name";
    public static int ACCURACY=0;

    @Override
    public String toString() {
        return "TemasEntry{" +
                "TEMAS='" + TABLE_NAME + '\'' +
                ", ID_TEMA='" + ID_THEME + '\'' +
                ", FK_ID_COURSE='" + FK_ID_COURSE + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ACCURACY='" + ACCURACY + '\'' +
                '}';
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdTema() {
        return ID_THEME;
    }

    public String getFkIdCourse() {
        return FK_ID_COURSE;
    }

    public String getName() {
        return NAME;
    }

    public int getAccuracy() {
        return ACCURACY;
    }
}
