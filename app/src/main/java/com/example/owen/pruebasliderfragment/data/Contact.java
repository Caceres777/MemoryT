package com.example.owen.pruebasliderfragment.data;

import android.graphics.Bitmap;
import android.provider.BaseColumns;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class Contact{

    public Contact() {
    }

    public static abstract class CursosEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String ID_COURSE = "id_course";
        public static final String DEFINITION="definition";
        public static final String NAME = "name";
        public static final int ACCURACY=0;
        public static final Bitmap IMAGE= null;
        public static final String TABLE_NAME = "CURSOS";
    }

    public static abstract class TemasEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String ID_THEME = "id_theme";
        public static final String FK_ID_COURSE = "id_course";
        public static final String NAME = "name";
        public static final int ACCURACY=0;
        public static final String TABLE_NAME = "TEMAS";
    }

    public static abstract class BadgesEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String ID_BADGE = "id_badge";
        public static final String FK_ID_COURSE = "id_course";
        public static final Bitmap IMAGE= null;
        public static final String TITLE = "title";
        public static final String TEXT = "text";
        public static final String TABLE_NAME = "BADGES";
    }

    public static abstract class PreguntasEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String ID_QUESTION = "id_question";
        public static final String FK_ID_THEME = "id_theme";
        public static final String TEXT = "text";
        public static final boolean DONE=true;
        public static int RIGHT=0;
        public static int WRONG=0;
        public static final String TABLE_NAME = "PREGUNTAS";
    }

    public static abstract class RespuestasEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String ID_ANSWER= "id_answer";
        public static final String FK_ID_QUESTION = "id_question";
        public static final String FK_ID_THEME = "id_theme";
        public static final String TEXT = "text";
        public static final String TABLE_NAME = "RESPUESTAS";
    }

}
//    public static abstract class UsuariosEntry implements
//            BaseColumns {
////        public static final String COLUMN_ID = BaseColumns._ID;
//        public static final String COLUMN_ID_USER = "id_usuarios";
//        public static final String COLUMN_NAME = "nombre";
//        public static final String COLUMN_EXP = "experiencia";
//        public static final String COLUMN_AVATAR = "avatar";
//        public static final String COLUMN_MAIL = "email";
//        public static final String COLUMN_PASSWORD = "password";
//        public static final String TABLE_NAME = "USUARIOS";
//    }