package com.example.owen.pruebasliderfragment.parse.DataEntry;

import java.io.Serializable;

/**
 * Created by Owen on 05/03/2015.
 */
public class BadgesEntry implements Serializable{
    private static final String TABLE_NAME = "Badges";
    private static final String courseID = "CourseID";
    private static final String name = "Name";
    private static final String definition = "Definition";
    private static final String image = "Image";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getCourseID() {
        return courseID;
    }

    public static String getDefinition() {
        return definition;
    }

    public static String getImage() {
        return image;
    }

    public static String getName() {
        return name;
    }


}
