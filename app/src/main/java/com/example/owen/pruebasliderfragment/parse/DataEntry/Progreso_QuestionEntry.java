package com.example.owen.pruebasliderfragment.parse.DataEntry;

import java.io.Serializable;

/**
 * Created by Owen on 05/03/2015.
 */
public class Progreso_QuestionEntry implements Serializable{
    private static final String TABLE_NAME = "Progreso_Question";
    private static final String userID = "UserID";
    private static final String questionID = "QuestionID";
    private static final String hits = "Hits";
    private static final String miss = "Miss";
    private static final String made = "Made";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getHits() {
        return hits;
    }

    public static String getMade() {
        return made;
    }

    public static String getMiss() {
        return miss;
    }

    public static String getQuestionID() {
        return questionID;
    }

    public static String getUserID() {
        return userID;
    }
}
