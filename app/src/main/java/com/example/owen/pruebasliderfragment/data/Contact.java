package com.example.owen.pruebasliderfragment.data;

import android.graphics.Bitmap;
import android.provider.BaseColumns;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by CHUFASCHIN on 29/01/2015.
 */
public class Contact{

    public Contact() {

    }

    public class BeanCursos implements Serializable {
        private String ID_COURSE;
        private String DEFINITION;
        private String NAME;
        private int ACCURACY;
        private Blob IMAGE;

        public void setIMAGE(Blob IMAGE) {
            this.IMAGE = IMAGE;
        }

        public void setACCURACY(int ACCURACY) {
            this.ACCURACY = ACCURACY;
        }

        public void setDEFINITION(String DEFINITION) {
            this.DEFINITION = DEFINITION;
        }

        public void setID_COURSE(String ID_COURSE) {
            this.ID_COURSE = ID_COURSE;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public Blob getIMAGE() {
            return IMAGE;
        }

        public int getACCURACY() {
            return ACCURACY;
        }

        public String getDEFINITION() {
            return DEFINITION;
        }

        public String getID_COURSE() {
            return ID_COURSE;
        }

        public String getNAME() {
            return NAME;
        }
    }




    public class BeanTemas implements Serializable {
        private String ID_THEME;
        private String FK_ID_COURSE;
        private String NAME;
        private int ACCURACY;

        public int getACCURACY() {
            return ACCURACY;
        }

        public String getNAME() {
            return NAME;
        }

        public String getFK_ID_COURSE() {
            return FK_ID_COURSE;
        }

        public String getID_THEME() {
            return ID_THEME;
        }

        public void setACCURACY(int ACCURACY) {
            this.ACCURACY = ACCURACY;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public void setFK_ID_COURSE(String FK_ID_COURSE) {
            this.FK_ID_COURSE = FK_ID_COURSE;
        }

        public void setID_THEME(String ID_THEME) {
            this.ID_THEME = ID_THEME;
        }
    }




    public class BeanBadges implements Serializable {
        private String ID_BADGE;
        private String FK_ID_COURSE;
        private Blob IMAGE;
        private String TITLE;
        private String TEXT;

        public String getFK_ID_COURSE() {
            return FK_ID_COURSE;
        }

        public Blob getIMAGE() {
            return IMAGE;
        }

        public String getID_BADGE() {
            return ID_BADGE;
        }

        public String getTEXT() {
            return TEXT;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setFK_ID_COURSE(String FK_ID_COURSE) {
            this.FK_ID_COURSE = FK_ID_COURSE;
        }

        public void setID_BADGE(String ID_BADGE) {
            this.ID_BADGE = ID_BADGE;
        }

        public void setIMAGE(Blob IMAGE) {
            this.IMAGE = IMAGE;
        }

        public void setTEXT(String TEXT) {
            this.TEXT = TEXT;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }
    }




    public class BeanPreguntas implements Serializable {
        private String ID_QUESTION;
        private String FK_ID_THEME;
        private String TEXT;
        private boolean DONE;
        private int RIGHT;
        private int WRONG;

        public void setTEXT(String TEXT) {
            this.TEXT = TEXT;
        }

        public void setDONE(boolean DONE) {
            this.DONE = DONE;
        }

        public void setFK_ID_THEME(String FK_ID_THEME) {
            this.FK_ID_THEME = FK_ID_THEME;
        }

        public void setID_QUESTION(String ID_QUESTION) {
            this.ID_QUESTION = ID_QUESTION;
        }

        public void setRIGHT(int RIGHT) {
            this.RIGHT = RIGHT;
        }

        public void setWRONG(int WRONG) {
            this.WRONG = WRONG;
        }

        public String getTEXT() {
            return TEXT;
        }

        public int getRIGHT() {
            return RIGHT;
        }

        public int getWRONG() {
            return WRONG;
        }

        public String getFK_ID_THEME() {
            return FK_ID_THEME;
        }

        public String getID_QUESTION() {
            return ID_QUESTION;
        }
    }




    public class BeanRespuestas implements Serializable {
        private String ID_ANSWER;
        private String FK_ID_QUESTION;
        private String FK_ID_THEME;
        private String TEXT;

        public void setFK_ID_THEME(String FK_ID_THEME) {
            this.FK_ID_THEME = FK_ID_THEME;
        }

        public void setTEXT(String TEXT) {
            this.TEXT = TEXT;
        }

        public void setFK_ID_QUESTION(String FK_ID_QUESTION) {
            this.FK_ID_QUESTION = FK_ID_QUESTION;
        }

        public void setID_ANSWER(String ID_ANSWER) {
            this.ID_ANSWER = ID_ANSWER;
        }

        public String getFK_ID_THEME() {
            return FK_ID_THEME;
        }

        public String getTEXT() {
            return TEXT;
        }

        public String getFK_ID_QUESTION() {
            return FK_ID_QUESTION;
        }

        public String getID_ANSWER() {
            return ID_ANSWER;
        }
    }

}