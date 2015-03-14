package com.example.owen.pruebasliderfragment.parse.DataEntry;

import java.io.Serializable;

/**
 * Created by Owen on 14/03/2015.
 */
public class AnswerEntry implements Serializable {
    private static final String TABLE_NAME = "Answer";
    private static final String text = "Text";
    private static final String chaptersID = "ChaptersID";
    private static final String questionID = "QuestionID";

    public static String getChaptersID() {
        return chaptersID;
    }

    public static String getQuestionID() {
        return questionID;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getText() {
        return text;
    }
}
