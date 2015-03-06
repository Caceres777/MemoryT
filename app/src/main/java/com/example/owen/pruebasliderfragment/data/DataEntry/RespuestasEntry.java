package com.example.owen.pruebasliderfragment.data.DataEntry;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class RespuestasEntry implements Serializable {
    //        public static final String COLUMN_ID = BaseColumns._ID;
    public static final String TABLE_NAME = "RESPUESTAS";
    public static final String ID_ANSWER= "id_answer";
    public static final String FK_ID_QUESTION = "id_question";
    public static final String FK_ID_THEME = "id_theme";
    public static final String TEXT = "text";

    @Override
    public String toString() {
        return "RespuestasEntry{" +
                "QUESTIONS='" + TABLE_NAME + '\'' +
                ", ID_ANSWER='" + ID_ANSWER + '\'' +
                ", FK_ID_QUESTION='" + FK_ID_QUESTION + '\'' +
                ", DONE='" + FK_ID_THEME + '\'' +
                ", TEXT='" + TEXT + '\'' +
                '}';
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    public String getIdAnswer() {
        return ID_ANSWER;
    }

    public String getFkIdQuestion() {
        return FK_ID_QUESTION;
    }

    public String getFkIdTheme() {
        return FK_ID_THEME;
    }

    public String getText() {
        return TEXT;
    }

}