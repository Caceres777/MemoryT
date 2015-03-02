package com.example.owen.pruebasliderfragment.data;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class ContactBean implements Serializable{
    ContactBean(){}
    public static class CursosEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static String TABLE_NAME = "CURSOS";
        private static String COLUMN_ID_CURSO = "id_curso";
        private static String COLUMN_NOMBRE = "nombre";
        private static int ACCURACY=0;
        private static boolean APROBADO=false;

        public static boolean isAPROBADO() {
            return APROBADO;
        }

        public static void setAPROBADO(boolean APROBADO) {
            CursosEntry.APROBADO = APROBADO;
        }

        public static int getACCURACY() {
            return ACCURACY;
        }

        public static void setACCURACY(int ACCURACY) {
            CursosEntry.ACCURACY = ACCURACY;
        }

        @Override
        public String toString() {
            return "CursosEntry{" +
                    "TABLE_NAME='" + TABLE_NAME + '\'' +
                    ", COLUMN_ID_CURSO='" + COLUMN_ID_CURSO + '\'' +
                    ", COLUMN_NOMBRE='" + COLUMN_NOMBRE + '\'' +
                    ", ACCURACY='" + ACCURACY + '\'' +
                    ", APROBADO='" + APROBADO + '\'' +
                    '}';
        }

        public void setTABLE_NAME(String TABLE_NAME) {
            this.TABLE_NAME = TABLE_NAME;
        }

        public void setCOLUMN_NOMBRE(String COLUMN_NOMBRE) {
            this.COLUMN_NOMBRE = COLUMN_NOMBRE;
        }

        public void setCOLUMN_ID_CURSO(String COLUMN_ID_CURSO) {
            this.COLUMN_ID_CURSO = COLUMN_ID_CURSO;
        }

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

    public static class TemasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static String COLUMN_NOMBRE = "nombre";
        private static String COLUMN_ID_TEMA = "id_tema";
        private static String COLUMN_ID_CURSO = "id_curso";
        private static int ACCURACY=0;
        private static boolean APROBADO=false;
        private static String TABLE_NAME = "TEMAS";

        public static int getACCURACY() {
            return ACCURACY;
        }

        public static void setACCURACY(int ACCURACY) {
            TemasEntry.ACCURACY = ACCURACY;
        }

        public static boolean isAPROBADO() {
            return APROBADO;
        }

        public static void setAPROBADO(boolean APROBADO) {
            TemasEntry.APROBADO = APROBADO;
        }

        @Override
        public String toString() {
            return "TemasEntry{" +
                    "COLUMN_NOMBRE='" + COLUMN_NOMBRE + '\'' +
                    ", COLUMN_ID_TEMA='" + COLUMN_ID_TEMA + '\'' +
                    ", COLUMN_ID_CURSO='" + COLUMN_ID_CURSO + '\'' +
                    ", ACCURACY='" + ACCURACY + '\'' +
                    ", APROBADO='" + APROBADO + '\'' +
                    ", TABLE_NAME='" + TABLE_NAME + '\'' +
                    '}';
        }

        public void setCOLUMN_NOMBRE(String COLUMN_NOMBRE) {
            this.COLUMN_NOMBRE = COLUMN_NOMBRE;
        }

        public void setCOLUMN_ID_TEMA(String COLUMN_ID_TEMA) {
            this.COLUMN_ID_TEMA = COLUMN_ID_TEMA;
        }

        public void setCOLUMN_ID_CURSO(String COLUMN_ID_CURSO) {
            this.COLUMN_ID_CURSO = COLUMN_ID_CURSO;
        }

        public void setTABLE_NAME(String TABLE_NAME) {
            this.TABLE_NAME = TABLE_NAME;
        }

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

    public static class PreguntasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static String COLUMN_ID_PREGUNTA = "id_pregunta";
        private static String COLUMN_NOMBRE = "nombre";
        private static String COLUMN_ID_TEMA = "id_tema";
        private static String TABLE_NAME = "PREGUNTAS";

        @Override
        public String toString() {
            return "PreguntasEntry{" +
                    "COLUMN_ID_PREGUNTA='" + COLUMN_ID_PREGUNTA + '\'' +
                    ", COLUMN_NOMBRE='" + COLUMN_NOMBRE + '\'' +
                    ", COLUMN_ID_TEMA='" + COLUMN_ID_TEMA + '\'' +
                    ", TABLE_NAME='" + TABLE_NAME + '\'' +
                    '}';
        }

        public void setCOLUMN_ID_PREGUNTA(String COLUMN_ID_PREGUNTA) {
            this.COLUMN_ID_PREGUNTA = COLUMN_ID_PREGUNTA;
        }

        public void setCOLUMN_NOMBRE(String COLUMN_NOMBRE) {
            this.COLUMN_NOMBRE = COLUMN_NOMBRE;
        }

        public void setCOLUMN_ID_TEMA(String COLUMN_ID_TEMA) {
            this.COLUMN_ID_TEMA = COLUMN_ID_TEMA;
        }

        public void setTABLE_NAME(String TABLE_NAME) {
            this.TABLE_NAME = TABLE_NAME;
        }

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

    public static class RespuestasEntry implements
            BaseColumns {
        //        public static final String COLUMN_ID = BaseColumns._ID;
        private static String COLUMN_ID_RESPUESTA= "id_respuesta";
        private static String COLUMN_NOMBRE = "nombre";
        private static String COLUMN_ID_PREGUNTA = "id_pregunta";
        private static String COLUMN_ID_TEMA = "id_tema";
        private static String TABLE_NAME = "RESPUESTAS";

        @Override
        public String toString() {
            return "RespuestasEntry{" +
                    "COLUMN_ID_RESPUESTA='" + COLUMN_ID_RESPUESTA + '\'' +
                    ", COLUMN_NOMBRE='" + COLUMN_NOMBRE + '\'' +
                    ", COLUMN_ID_PREGUNTA='" + COLUMN_ID_PREGUNTA + '\'' +
                    ", COLUMN_ID_TEMA='" + COLUMN_ID_TEMA + '\'' +
                    ", TABLE_NAME='" + TABLE_NAME + '\'' +
                    '}';
        }

        public void setCOLUMN_ID_RESPUESTA(String COLUMN_ID_RESPUESTA) {
            this.COLUMN_ID_RESPUESTA = COLUMN_ID_RESPUESTA;
        }

        public void setCOLUMN_NOMBRE(String COLUMN_NOMBRE) {
            this.COLUMN_NOMBRE = COLUMN_NOMBRE;
        }

        public void setCOLUMN_ID_PREGUNTA(String COLUMN_ID_PREGUNTA) {
            this.COLUMN_ID_PREGUNTA = COLUMN_ID_PREGUNTA;
        }

        public void setCOLUMN_ID_TEMA(String COLUMN_ID_TEMA) {
            this.COLUMN_ID_TEMA = COLUMN_ID_TEMA;
        }

        public void setTABLE_NAME(String TABLE_NAME) {
            this.TABLE_NAME = TABLE_NAME;
        }

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
