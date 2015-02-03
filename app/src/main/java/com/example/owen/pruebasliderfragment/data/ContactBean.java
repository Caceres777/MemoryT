package com.example.owen.pruebasliderfragment.data;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class ContactBean implements Serializable{
    ContactBean(){}

    public static abstract class UsuariosEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
//        private String usuario;
        private static final String COLUMN_ID_USER = "id_usuario";
        private static final String COLUMN_NAME = "nombre";
        private static final String COLUMN_EXP = "experiencia";
        private static final String COLUMN_AVATAR = "avatar";
        private static final String COLUMN_MAIL = "email";
        private static final String COLUMN_PASSWORD = "password";
        private static final String TABLE_NAME = "USUARIOS";

        public static String getColumnIdUser() {
            return COLUMN_ID_USER;
        }

        public static String getColumnName() {
            return COLUMN_NAME;
        }

        public static String getColumnExp() {
            return COLUMN_EXP;
        }

        public static String getColumnAvatar() {
            return COLUMN_AVATAR;
        }

        public static String getColumnMail() {
            return COLUMN_MAIL;
        }

        public static String getColumnPassword() {
            return COLUMN_PASSWORD;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }
    }

    public static abstract class CursosEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static final String COLUMN_ID_CURSO = "id_curso";
        private static final String COLUMN_NOMBRE = "nombre";
        private static final String TABLE_NAME = "CURSOS";

        public static String getColumnIdCurso() {
            return COLUMN_ID_CURSO;
        }

        public static String getColumnNombre() {
            return COLUMN_NOMBRE;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }
    }

    public static abstract class TemasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static final String COLUMN_NOMBRE = "nombre";
        private static final String COLUMN_ID_TEMA = "id_tema";
        private static final String COLUMN_ID_CURSO = "id_curso";
        private static final String TABLE_NAME = "TEMAS";

        public static String getColumnNombre() {
            return COLUMN_NOMBRE;
        }

        public static String getColumnIdTema() {
            return COLUMN_ID_TEMA;
        }

        public static String getColumnIdCurso() {
            return COLUMN_ID_CURSO;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }
    }

    public static abstract class PreguntasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static final String COLUMN_ID_PREGUNTA = "id_pregunta";
        private static final String COLUMN_NOMBRE = "nombre";
        private static final String COLUMN_ID_TEMA = "id_tema";
        private static final String TABLE_NAME = "PREGUNTAS";

        public static String getColumnNombre() {
            return COLUMN_NOMBRE;
        }

        public static String getColumnIdPregunta() {
            return COLUMN_ID_PREGUNTA;
        }

        public static String getColumnIdTema() {
            return COLUMN_ID_TEMA;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }
    }

    public static abstract class RespuestasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static final String COLUMN_ID_RESPUESTA= "id_respuesta";
        private static final String COLUMN_NOMBRE = "nombre";
        private static final String COLUMN_ID_PREGUNTA = "id_pregunta";
        private static final String COLUMN_ID_TEMA = "id_tema";
        private static final String TABLE_NAME = "RESPUESTAS";

        public static String getColumnIdRespuesta() {
            return COLUMN_ID_RESPUESTA;
        }

        public static String getColumnIdPregunta() {
            return COLUMN_ID_PREGUNTA;
        }

        public static String getColumnIdTema() {
            return COLUMN_ID_TEMA;
        }

        public static String getColumnNombre() {
            return COLUMN_NOMBRE;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }
    }

}
