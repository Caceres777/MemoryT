package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
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
