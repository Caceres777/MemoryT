package com.example.owen.pruebasliderfragment.parse.DataEntry;

import java.io.Serializable;

/**
 * Created by Owen on 05/03/2015.
 */
public class QuestionEntry implements Serializable{
    private static final String TABLE_NAME = "Question";
    private static final String chapterID = "ChaptersID";
    private static final String text = "Text";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getChapterID() {
        return chapterID;
    }

    public static String getText() {
        return text;
    }
}
