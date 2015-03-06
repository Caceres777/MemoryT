package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanCursos implements Serializable {
    private int ID_COURSE;
    private String ID_PARSE;
    private String DEFINITION;
    private String NAME;
    private int ACCURACY;
    private byte[] IMAGE;

    public BeanCursos(int ID_COURSE, String ID_PARSE, String DEFINITION, String NAME, int ACCURACY, byte[] IMAGE){
        this.ID_COURSE = ID_COURSE;
        this.ACCURACY = ACCURACY;
        this.ID_PARSE = ID_PARSE;
        this.DEFINITION = DEFINITION;
        this.NAME=NAME;
        this.IMAGE=IMAGE;
    }

    public void setIMAGE(byte[] IMAGE) {
        this.IMAGE = IMAGE;
    }

    public void setACCURACY(int ACCURACY) {
        this.ACCURACY = ACCURACY;
    }

    public void setDEFINITION(String DEFINITION) {
        this.DEFINITION = DEFINITION;
    }

    public void setID_COURSE(int ID_COURSE) {
        this.ID_COURSE = ID_COURSE;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public byte[] getIMAGE() {
        return IMAGE;
    }

    public void setID_PARSE(String ID_PARSE) {
        this.ID_PARSE = ID_PARSE;
    }

    public int getACCURACY() {
        return ACCURACY;
    }

    public String getDEFINITION() {
        return DEFINITION;
    }

    public int getID_COURSE() {
        return ID_COURSE;
    }

    public String getNAME() {
        return NAME;
    }

    public String getID_PARSE() {
        return ID_PARSE;
    }
}
