package com.example.owen.pruebasliderfragment.data;

import android.provider.BaseColumns;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class Contact{

    public Contact() {
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

    public static abstract class CursosEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_ID_CURSO = "id_curso";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String ACCURACY="accuracy";
        public static final String TABLE_NAME = "CURSOS";

    }

    public static abstract class TemasEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_ID_TEMA = "id_tema";
        public static final String COLUMN_ID_CURSO = "id_curso";
        public static final String ACCURACY="accuracy";
        public static final String TABLE_NAME = "TEMAS";
    }

    public static abstract class PreguntasEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_ID_PREGUNTA = "id_pregunta";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_ID_TEMA = "id_tema";
        public static final String TABLE_NAME = "PREGUNTAS";
    }

    public static abstract class RespuestasEntry implements
            BaseColumns {
//        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_ID_RESPUESTA= "id_respuesta";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_ID_PREGUNTA = "id_pregunta";
        public static final String COLUMN_ID_TEMA = "id_tema";
        public static final String TABLE_NAME = "RESPUESTAS";
    }

}