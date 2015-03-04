package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
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
