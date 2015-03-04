package com.example.owen.pruebasliderfragment.data;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class CursosEntry implements Serializable {
    //        public static final String COLUMN_ID = BaseColumns._ID;
    public static String TABLE_NAME = "CURSOS";
    public static String ID_COURSE = "id_course";
    public static String DEFINITION="definition";
    public static String NAME = "name";
    public static int ACCURACY=0;
    public static Bitmap IMAGE= null;

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

    public void setID_COURSE(String ID_COURSE) {
        CursosEntry.ID_COURSE = ID_COURSE;
    }

    public String getDEFINITION() {
        return DEFINITION;
    }

    public void setDEFINITION(String DEFINITION) {
        CursosEntry.DEFINITION = DEFINITION;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        CursosEntry.NAME = NAME;
    }

    public int getACCURACY() {
        return ACCURACY;
    }

    public void setACCURACY(int ACCURACY) {
        CursosEntry.ACCURACY = ACCURACY;
    }

    public Bitmap getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(Bitmap IMAGE) {
        CursosEntry.IMAGE = IMAGE;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        CursosEntry.TABLE_NAME = TABLE_NAME;
    }
}