package com.example.owen.pruebasliderfragment.data;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 04/03/2015.
 */
public class PreguntasEntry implements Serializable{

//    private int id;
        //        public static final String COLUMN_ID = BaseColumns._ID;
    public static final String TABLE_NAME = "PREGUNTAS";
    public static final String ID_QUESTION = "id_question";
    public static final String FK_ID_THEME = "fk_id_theme";
    public static final String TEXT = "text";
    public static final boolean DONE=true;
    public static int RIGHT=0;
    public static int WRONG=0;

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

        public boolean isDone() {
            return DONE;
        }

        public int getRIGHT() {
            return RIGHT;
        }

        public void setRIGHT(int RIGHT) {
            PreguntasEntry.RIGHT = RIGHT;
        }

        public int getWRONG() {
            return WRONG;
        }

        public void setWRONG(int WRONG) {
            PreguntasEntry.WRONG = WRONG;
        }
    }


