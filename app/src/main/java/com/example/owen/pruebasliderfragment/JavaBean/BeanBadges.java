package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanBadges implements Serializable {
    private String ID_BADGE;
    private String FK_ID_COURSE;
    private byte[] IMAGE;
    private String TITLE;
    private String TEXT;

    public BeanBadges(String ID_BADGE, String FK_ID_COURSE, byte[] IMAGE, String TITLE, String TEXT){
        this.ID_BADGE = ID_BADGE;
        this.FK_ID_COURSE = FK_ID_COURSE;
        this.IMAGE = IMAGE;
        this.TITLE = TITLE;
        this.TEXT = TEXT;
    }

    public String getFK_ID_COURSE() {
        return FK_ID_COURSE;
    }

    public byte[] getIMAGE() {
        return IMAGE;
    }

    public String getID_BADGE() {
        return ID_BADGE;
    }

    public String getTEXT() {
        return TEXT;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setFK_ID_COURSE(String FK_ID_COURSE) {
        this.FK_ID_COURSE = FK_ID_COURSE;
    }

    public void setID_BADGE(String ID_BADGE) {
        this.ID_BADGE = ID_BADGE;
    }

    public void setIMAGE(byte[] IMAGE) {
        this.IMAGE = IMAGE;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }
}
