package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanRespuestas implements Serializable {
    private int ID_ANSWER;
    private int FK_ID_QUESTION;
    private int FK_ID_THEME;
    private String TEXT;

    public BeanRespuestas(int ID_ANSWER, int FK_ID_QUESTION, int FK_ID_THEME, String TEXT){
        this.ID_ANSWER = ID_ANSWER;
        this.FK_ID_QUESTION = FK_ID_QUESTION;
        this.FK_ID_THEME = FK_ID_THEME;
        this.TEXT = TEXT;
    }

    public void setFK_ID_THEME(int FK_ID_THEME) {
        this.FK_ID_THEME = FK_ID_THEME;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public void setFK_ID_QUESTION(int FK_ID_QUESTION) {
        this.FK_ID_QUESTION = FK_ID_QUESTION;
    }

    public void setID_ANSWER(int ID_ANSWER) {
        this.ID_ANSWER = ID_ANSWER;
    }

    public int getFK_ID_THEME() {
        return FK_ID_THEME;
    }

    public String getTEXT() {
        return TEXT;
    }

    public int getFK_ID_QUESTION() {
        return FK_ID_QUESTION;
    }

    public int getID_ANSWER() {
        return ID_ANSWER;
    }
}
