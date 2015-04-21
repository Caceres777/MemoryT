package com.example.owen.pruebasliderfragment.data;

import android.provider.BaseColumns;

/**
 * Created by Owen on 13/04/2015.
 */
public class SQLContract {

    public SQLContract(){}

    public static abstract class CourseEntry implements BaseColumns{
        public static final String TABLE_NAME = "COURSES";
        public static final String ID = "id";
        public static final String ID_PARSE = "id_parse";
        public static final String DEFINITION="definition";
        public static final String NAME = "name";
        public static final String ACCURACY="accuracy";
        public static final String PROGRESS="progress";
        public static final String IMAGE= "image";
    }

    public static abstract class ChapterEntry implements BaseColumns{
        public static String TABLE_NAME = "CHAPTERS";
        public static String ID_PARSE = "id_parse";
        public static String ID = "id";
        public static String FK_ID_COURSE = "fk_id_course";
        public static String NAME = "name";
        public static String ACCURACY="accuracy";
        public static final String PROGRESS="progress";
        public static String POSITION="position";
    }

    public static abstract class QuestionEntry implements BaseColumns{
        public static final String TABLE_NAME = "QUESTIONS";
        public static final String ID = "id";
        public static final String ID_PARSE = "id_parse";
        public static final String FK_ID_THEME = "fk_id_theme";
        public static final String TEXT1 = "text1";
        public static final String TEXT2 = "text2";
        public static final String TOTAL = "total";
        public static final String IMAGE = "image";
        public static final String EF = "ef";
        public static final String WRONG="wrong";
        public static final String ASKED="asked";
        public static final String REVIEW="review";
    }

    public static abstract class BadgesEntry implements BaseColumns{
        public static final String TABLE_NAME = "BADGES";
        public static final String ID = "id";
        public static final String ID_PARSE = "id_parse";
        public static final String FK_ID_COURSE = "fk_id_course";
        public static final String IMAGE= "IMAGE";
        public static final String TITLE = "title";
        public static final String TEXT = "text";
    }
}
