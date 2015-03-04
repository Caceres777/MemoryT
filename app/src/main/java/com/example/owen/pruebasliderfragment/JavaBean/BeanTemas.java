package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
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
