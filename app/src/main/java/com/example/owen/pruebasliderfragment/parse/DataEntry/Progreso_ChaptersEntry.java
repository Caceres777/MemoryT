package com.example.owen.pruebasliderfragment.parse.DataEntry;

/**
 * Created by Owen on 05/03/2015.
 */
public class Progreso_ChaptersEntry {

    private static final String TABLE_NAME = "Progreso_Chapters";
    private static final String userID = "UserID";
    private static final String chapterID = "ChaptersID";
    private static final String Accuracy = "Accuracy";
    private static final String finished = "Finished";
    private static final String progress = "Progress";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getUserID() {
        return userID;
    }

    public static String getAccuracy() {
        return Accuracy;
    }

    public static String getChapterID() {
        return chapterID;
    }

    public static String getFinished() {
        return finished;
    }

    public static String getProgress() {
        return progress;
    }
}
