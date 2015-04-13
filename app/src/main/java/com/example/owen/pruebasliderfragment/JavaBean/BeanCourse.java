package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanCourse implements Serializable {
    private int ID;
    private String ID_PARSE;
    private String DEFINITION;
    private String NAME;
    private int PROGRESS;
    private byte[] IMAGE;

    public BeanCourse(int ID, String ID_PARSE, String DEFINITION, String NAME, byte[] IMAGE, int PROGRESS){
        this.ID = ID;
        this.ID_PARSE = ID_PARSE;
        this.DEFINITION = DEFINITION;
        this.NAME=NAME;
        this.PROGRESS = PROGRESS;
        this.IMAGE=IMAGE;
    }

    public void setPROGRESS(int PROGRESS) {
        this.PROGRESS = PROGRESS;
    }

    public void setIMAGE(byte[] IMAGE) {
        this.IMAGE = IMAGE;
    }

    public void setDEFINITION(String DEFINITION) {
        this.DEFINITION = DEFINITION;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getDEFINITION() {
        return DEFINITION;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getID_PARSE() {
        return ID_PARSE;
    }

    public int getPROGRESS() {
        return PROGRESS;
    }
}
