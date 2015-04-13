package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanChapter implements Serializable {
    private int ID;
    private String ID_PARSE;
    private int FK_ID_COURSE;
    private String NAME;
    private int ACCURACY;
    private int PROGRESS;
    private int POSITION;

    public BeanChapter(int ID, String ID_PARSE, int FK_ID_COURSE, String NAME, int ACCURACY, int POSITION, int PROGRESS){
        this.ID = ID;
        this.ID_PARSE = ID_PARSE;
        this.FK_ID_COURSE = FK_ID_COURSE;
        this.NAME = NAME;
        this.ACCURACY = ACCURACY;
        this.PROGRESS = PROGRESS;
        this.POSITION = POSITION;
    }

    public int getPROGRESS() {
        return PROGRESS;
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

    public int getID() {
        return ID;
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_PARSE(String ID_PARSE) {
        this.ID_PARSE = ID_PARSE;
    }

    public void setPOSITION(int POSITION) {
        this.POSITION = POSITION;
    }

    public void setPROGRESS(int PROGRESS) {
        this.PROGRESS = PROGRESS;
    }
}
