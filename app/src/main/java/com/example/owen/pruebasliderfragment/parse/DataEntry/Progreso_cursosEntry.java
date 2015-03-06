package com.example.owen.pruebasliderfragment.parse.DataEntry;

import java.io.Serializable;

/**
 * Created by Owen on 05/03/2015.
 */
public class Progreso_cursosEntry implements Serializable{

    private static final String TABLE_NAME = "Progreso_Cursos";
    private static final String userID = "UserID";
    private static final String courseID = "CourseID";
    private static final String accuracy = "Accuracy";
    private static final String Finished = "Finished";
    private static final String progress = "Progress";

    public static String getAccuracy() {
        return accuracy;
    }

    public static String getCourseID() {
        return courseID;
    }

    public static String getFinished() {
        return Finished;
    }

    public static String getUserID() {
        return userID;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getProgress() {
        return progress;
    }
}
