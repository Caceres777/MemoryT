package com.example.owen.pruebasliderfragment.parse.DataEntry;

import com.example.owen.pruebasliderfragment.fragments.SearchCourses_frag;

import java.io.Serializable;

/**
 * Created by Owen on 05/03/2015.
 */
public class Progreso_BadgesEntry implements Serializable{
    private static final String TABLE_NAME = "Progreso_Badges";
    private static final String badgesID = "BadgesID";
    private static final String userID = "UserID";
    private static final String obtained = "Obtained";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getUserID() {
        return userID;
    }

    public static String getBadgesID() {
        return badgesID;
    }

    public static String getObtained() {
        return obtained;
    }
}
