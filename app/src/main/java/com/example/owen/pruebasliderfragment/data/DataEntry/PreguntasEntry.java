package com.example.owen.pruebasliderfragment.data.DataEntry;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class PreguntasEntry implements Serializable{

//    private int id;
        //        public static final String COLUMN_ID = BaseColumns._ID;
    public static final String TABLE_NAME = "PREGUNTAS";
    public static final String ID_QUESTION = "id_question";
    public static final String ID_PARSE = "id_parse";
    public static final String FK_ID_THEME = "fk_id_theme";
    public static final String TEXT = "text";
    public static final String DONE="done";
    public static final String RIGHT="correct";
    public static final String WRONG="wrong";

    @Override
    public String toString() {
        return "PreguntasEntry{" +
                "QUESTIONS='" + TABLE_NAME + '\'' +
                ", ID_QUESTION='" + ID_QUESTION + '\'' +
                ", FK_ID_THEME='" + FK_ID_THEME + '\'' +
                ", TEXT='" + TEXT + '\'' +
                ", DONE='" + DONE + '\'' +
                ", RIGHT='" + RIGHT + '\'' +
                ", WRONG='" + WRONG + '\'' +
                '}';
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdQuestion() {
        return ID_QUESTION;
    }

    public String getIdTheme() {
        return FK_ID_THEME;
    }

    public String getText() {
        return TEXT;
    }

    public static String getDone() {
        return DONE;
    }

    public static String getRight() {
        return RIGHT;
    }

    public static String getWrong() {
        return WRONG;
    }

    public static String getFkIdTheme() {
        return FK_ID_THEME;
    }

    public static String getIdParse() {
        return ID_PARSE;
    }
}


