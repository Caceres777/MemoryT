package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanPreguntas implements Serializable {
    private int ID_QUESTION;
    private String PARSE_ID;
    private int FK_ID_THEME;
    private String TEXT;
    private boolean DONE;
    private int RIGHT;
    private int WRONG;

    public BeanPreguntas(int ID_QUESTION, String PARSE_ID, int FK_ID_THEME, String TEXT, boolean DONE, int RIGHT, int WRONG){
        this.ID_QUESTION = ID_QUESTION;
        this.PARSE_ID = PARSE_ID;
        this.FK_ID_THEME = FK_ID_THEME;
        this.TEXT = TEXT;
        this.DONE = DONE;
        this.RIGHT = RIGHT;
        this.WRONG = WRONG;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public void setDONE(boolean DONE) {
        this.DONE = DONE;
    }

    public void setFK_ID_THEME(int FK_ID_THEME) {
        this.FK_ID_THEME = FK_ID_THEME;
    }

    public void setID_QUESTION(int ID_QUESTION) {
        this.ID_QUESTION = ID_QUESTION;
    }

    public void setRIGHT(int RIGHT) {
        this.RIGHT = RIGHT;
    }

    public void setWRONG(int WRONG) {
        this.WRONG = WRONG;
    }

    public void setPARSE_ID(String PARSE_ID) {
        this.PARSE_ID = PARSE_ID;
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

    public boolean getDONE(){
        return DONE;
    }

    public int getFK_ID_THEME() {
        return FK_ID_THEME;
    }

    public int getID_QUESTION() {
        return ID_QUESTION;
    }

    public String getPARSE_ID() {
        return PARSE_ID;
    }
}
