package com.example.owen.pruebasliderfragment.parse;

import android.provider.BaseColumns;

/**
 * Created by Owen on 13/04/2015.
 */
public class ParseContract {

    public ParseContract(){}

    public static abstract class CourseEntry implements BaseColumns{
        public static final String TABLE_NAME = "Course";
        public static final String NAME = "Name";
        public static final String DEFINITION = "Definition";
        public static final String IMAGE = "Image";
    }

    public static abstract class ChapterEntry implements BaseColumns{
        public static final String TABLE_NAME = "Chapters";
        public static final String POSITION = "Position";
        public static final String NAME = "Name";
        public static final String COURSE_ID = "CourseID";
    }

    public static abstract class QuestionEntry implements BaseColumns{
        public static final String TABLE_NAME = "Questions";
        public static final String CHAPTER_ID = "ChaptersID";
        public static final String TEXT1 = "Text1";
        public static final String TEXT2 = "Text2";
        public static final String IMAGE = "Image";
    }

    public static abstract class badgesEntry implements BaseColumns{
        public static final String TABLE_NAME = "Badges";
        public static final String COURSE_ID = "CourseID";
        public static final String NAME = "Name";
        public static final String DEFINITION = "Definition";
        public static final String IMAGE = "Image";
    }

    public static abstract class Progress_courseEntry implements BaseColumns{
        public static final String TABLE_NAME = "Progress_course";
        public static final String USER_ID = "UserID";
        public static final String COURSE_ID = "CourseID";
        //public static final String accuracy = "Accuracy"; // no es necesario
        //public static final String Finished = "Finished"; // xomprobar a traves de progress
        public static final String PROGRESS = "Progress";
    }

    public static abstract class Progress_chapterEntry implements BaseColumns{
        public static final String TABLE_NAME = "Progress_chapter";
        public static final String USER_ID = "UserID";
        public static final String CHAPTER_ID = "ChaptersID";
        public static final String ACCURACY = "Accuracy";
        //public static final String finished = "Finished"; // comprobar a traves de progress
        public static final String PROGRESS = "Progress";
    }

    public static abstract class Progress_questionEntry implements BaseColumns{
        public static final String TABLE_NAME = "Progress_question";
        public static final String USER_ID = "UserID";
        public static final String QUESTION_ID = "QuestionID";
        public static final String TOTAL = "Total";
        public static final String MISS = "Miss";
        public static final String EF = "EF"; // coficiente de repeticion
    }

    public static abstract class Progress_badgesEntry implements BaseColumns{
        public static final String TABLE_NAME = "Progreso_Badges";
        public static final String BADGES_ID = "BadgesID";
        public static final String USER_ID = "UserID";
        public static final String OBTAINED = "Obtained";
    }
}
