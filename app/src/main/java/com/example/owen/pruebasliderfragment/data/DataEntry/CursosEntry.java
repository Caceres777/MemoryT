package com.example.owen.pruebasliderfragment.data.DataEntry;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class CursosEntry implements Serializable {
    public static final String TABLE_NAME = "CURSOS";
    public static final String ID_COURSE = "id_course";
    public static final String DEFINITION="definition";
    public static final String NAME = "name";
    public static final String ACCURACY="accuracy";
    public static final String IMAGE= "image";

    @Override
    public String toString() {
        return "CursosEntry{" +
                "CURSOS='" + TABLE_NAME + '\'' +
                ", ID_COURSE='" + ID_COURSE + '\'' +
                ", DEFINITION='" + DEFINITION + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ACCURACY='" + ACCURACY + '\'' +
                ", IMAGE='" + IMAGE +
                '}';
    }

    public String getID_COURSE() {
        return ID_COURSE;
    }

    public String getDEFINITION() {
        return DEFINITION;
    }

    public String getNAME() {
        return NAME;
    }

    public static String getACCURACY() {
        return ACCURACY;
    }

    public static String getIMAGE() {
        return IMAGE;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}