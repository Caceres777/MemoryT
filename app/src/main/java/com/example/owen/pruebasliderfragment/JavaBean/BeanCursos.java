package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Owen on 04/03/2015.
 */
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
