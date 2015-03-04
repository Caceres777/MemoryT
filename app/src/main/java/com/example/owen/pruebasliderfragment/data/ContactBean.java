package com.example.owen.pruebasliderfragment.data;

import android.graphics.Bitmap;
import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * private static String TABLE_NAME = "CURSOS";
 private
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class ContactBean implements Serializable{
    ContactBean(){}

    public static class CursosEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        public static String TABLE_NAME = "CURSOS";
        public static String ID_COURSE = "id_course";
        public static String DEFINITION="definition";
        public static String NAME = "name";
        public static int ACCURACY=0;
        public static Bitmap IMAGE= null;

        @Override
        public String toString() {
            return "CursosEntry{" +
                    "CURSOS='" + TABLE_NAME + '\'' +
                    ", ID_COURSE='" + ID_COURSE + '\'' +
                    ", DEFINITION='" + DEFINITION + '\'' +
                    ", NAME='" + NAME + '\'' +
                    ", ACCURACY='" + ACCURACY + '\'' +
                    ", IMAGE='" + IMAGE +
                    '}';
        }

        public static String getID_COURSE() {
            return ID_COURSE;
        }

        public static void setID_COURSE(String ID_COURSE) {
            CursosEntry.ID_COURSE = ID_COURSE;
        }

        public static String getDEFINITION() {
            return DEFINITION;
        }

        public static void setDEFINITION(String DEFINITION) {
            CursosEntry.DEFINITION = DEFINITION;
        }

        public static String getNAME() {
            return NAME;
        }

        public static void setNAME(String NAME) {
            CursosEntry.NAME = NAME;
        }

        public static int getACCURACY() {
            return ACCURACY;
        }

        public static void setACCURACY(int ACCURACY) {
            CursosEntry.ACCURACY = ACCURACY;
        }

        public static Bitmap getIMAGE() {
            return IMAGE;
        }

        public static void setIMAGE(Bitmap IMAGE) {
            CursosEntry.IMAGE = IMAGE;
        }

        public static String getTABLE_NAME() {
            return TABLE_NAME;
        }

        public static void setTABLE_NAME(String TABLE_NAME) {
            CursosEntry.TABLE_NAME = TABLE_NAME;
        }
    }

    public static class TemasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static final String TABLE_NAME = "TEMAS";
        private static final String ID_TEMA = "id_theme";
        private static final String FK_ID_COURSE = "fk_id_course";
        private static final String NAME = "name";
        private static final int ACCURACY=0;

        @Override
        public String toString() {
            return "TemasEntry{" +
                    "TEMAS='" + TABLE_NAME + '\'' +
                    ", ID_TEMA='" + ID_TEMA + '\'' +
                    ", FK_ID_COURSE='" + FK_ID_COURSE + '\'' +
                    ", NAME='" + NAME + '\'' +
                    ", ACCURACY='" + ACCURACY + '\'' +
                    '}';
        }

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getIdTema() {
            return ID_TEMA;
        }

        public static String getFkIdCourse() {
            return FK_ID_COURSE;
        }

        public static String getName() {
            return NAME;
        }

        public static int getAccuracy() {
            return ACCURACY;
        }
    }

    public static abstract class BadgesEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static final String TABLE_NAME = "BADGES";
        private static final String ID_BADGE = "id_badge";
        private static final String FK_ID_COURSE = "fk_id_course";
        private static final Bitmap IMAGE= null;
        private static final String TITLE = "title";
        private static final String TEXT = "text";

        @Override
        public String toString() {
            return "BadgesEntry{" +
                    "BADGES='" + TABLE_NAME + '\'' +
                    ", ID_BADGE='" + ID_BADGE + '\'' +
                    ", FK_ID_COURSE='" + FK_ID_COURSE + '\'' +
                    ", IMAGE='" + IMAGE + '\'' +
                    ", TITLE='" + TITLE + '\'' +
                    ", TEXT='" + TEXT + '\'' +
                    '}';
        }

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getIdBadge() {
            return ID_BADGE;
        }

        public static String getFkIdCourse() {
            return FK_ID_COURSE;
        }

        public static Bitmap getImage() {
            return IMAGE;
        }

        public static String getTitle() {
            return TITLE;
        }

        public static String getText() {
            return TEXT;
        }

    }

    public static abstract class PreguntasEntry implements
            BaseColumns {
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

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getIdQuestion() {
            return ID_QUESTION;
        }

        public static String getIdTheme() {
            return FK_ID_THEME;
        }

        public static String getText() {
            return TEXT;
        }

        public static boolean isDone() {
            return DONE;
        }

        public static int getRIGHT() {
            return RIGHT;
        }

        public static void setRIGHT(int RIGHT) {
            PreguntasEntry.RIGHT = RIGHT;
        }

        public static int getWRONG() {
            return WRONG;
        }

        public static void setWRONG(int WRONG) {
            PreguntasEntry.WRONG = WRONG;
        }
    }

    public static abstract class RespuestasEntry implements
            BaseColumns {
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

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getIdAnswer() {
            return ID_ANSWER;
        }

        public static String getFkIdQuestion() {
            return FK_ID_QUESTION;
        }

        public static String getFkIdTheme() {
            return FK_ID_THEME;
        }

        public static String getText() {
            return TEXT;
        }

    }

}
