package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanTemas implements Serializable {
    private int ID_THEME;
    private String ID_PARSE;
    private int FK_ID_COURSE;
    private String NAME;
    private int ACCURACY;
    private int POSITION;

    public BeanTemas(int ID_THEME, String ID_PARSE, int FK_ID_COURSE, String NAME, int ACCURACY, int POSITION){
        this.ID_THEME = ID_THEME;
        this.ID_PARSE = ID_PARSE;
        this.FK_ID_COURSE = FK_ID_COURSE;
        this.NAME = NAME;
        this.ACCURACY = ACCURACY;
        this.POSITION = POSITION;
    }

    public int getACCURACY() {
        return ACCURACY;
    }

    public String getNAME() {
        return NAME;
    }

    public int getFK_ID_COURSE() {
        return FK_ID_COURSE;
    }

    public int getID_THEME() {
        return ID_THEME;
    }

    public String getID_PARSE() {
        return ID_PARSE;
    }

    public int getPOSITION() {
        return POSITION;
    }

    public void setACCURACY(int ACCURACY) {
        this.ACCURACY = ACCURACY;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setFK_ID_COURSE(int FK_ID_COURSE) {
        this.FK_ID_COURSE = FK_ID_COURSE;
    }

    public void setID_THEME(int ID_THEME) {
        this.ID_THEME = ID_THEME;
    }

    public void setID_PARSE(String ID_PARSE) {
        this.ID_PARSE = ID_PARSE;
    }

    public void setPOSITION(int POSITION) {
        this.POSITION = POSITION;
    }
}
