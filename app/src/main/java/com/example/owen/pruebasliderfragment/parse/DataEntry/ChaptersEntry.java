package com.example.owen.pruebasliderfragment.parse.DataEntry;

import java.io.Serializable;

/**
 * Created by Owen on 05/03/2015.
 */
public class ChaptersEntry implements Serializable{

    private static final String TABLE_NAME = "Chapters";
    private static final String position = "position";
    private static final String name = "name";
    private static final String curso = "Curso";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getName() {
        return name;
    }

    public static String getCurso() {
        return curso;
    }

    public static String getPosition() {
        return position;
    }
}
