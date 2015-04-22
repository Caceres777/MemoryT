package com.example.owen.pruebasliderfragment.JavaBean;

import java.io.Serializable;

/**
 * Created by Owen on 04/03/2015.
 */
public class BeanQuestions implements Serializable {
    private int ID;
    private String PARSE_ID;
    private int FK_ID_THEME;
    private String TEXT1;
    private String TEXT2;
    private int TOTAL;
    private int WRONG;
    private Double EF;
    private byte[] IMAGE;
    private int ASKED;
    private long REVIEW;

    public BeanQuestions(int ID, String PARSE_ID, int FK_ID_THEME, String TEXT1, String TEXT2, int TOTAL, int WRONG, Double EF, byte[] IMAGE, int ASKED, long REVIEW){
        this.ID = ID;
        this.PARSE_ID = PARSE_ID;
        this.FK_ID_THEME = FK_ID_THEME;
        this.TEXT1 = TEXT1;
        this.TEXT2 = TEXT2;
        this.TOTAL = TOTAL;
        this.WRONG = WRONG;
        this.EF = EF;
        this.IMAGE = IMAGE;
        this.ASKED = ASKED;
        this.REVIEW = REVIEW;
    }

    public void setASKED(int ASKED) {
        this.ASKED = ASKED;
    }

    public void setIMAGE(byte[] IMAGE) {
        this.IMAGE = IMAGE;
    }

    public void setTEXT1(String TEXT1) {
        this.TEXT1 = TEXT1;
    }

    public void setTEXT2(String TEXT2) {
        this.TEXT2 = TEXT2;
    }

    public void setFK_ID_THEME(int FK_ID_THEME) {
        this.FK_ID_THEME = FK_ID_THEME;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    public void setWRONG(int WRONG) {
        this.WRONG = WRONG;
    }

    public void setPARSE_ID(String PARSE_ID) {
        this.PARSE_ID = PARSE_ID;
    }

    public void setEF(Double EF) {
        this.EF = EF;
    }

    public void setREVIEW(long REVIEW) {
        this.REVIEW = REVIEW;
    }

    public byte[] getIMAGE() {
        return IMAGE;
    }

    public String getTEXT1() {
        return TEXT1;
    }

    public String getTEXT2() {
        return TEXT2;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public int getWRONG() {
        return WRONG;
    }

    public int getFK_ID_THEME() {
        return FK_ID_THEME;
    }

    public int getID() {
        return ID;
    }

    public String getPARSE_ID() {
        return PARSE_ID;
    }

    public Double getEF() {
        return EF;
    }

    public int getASKED(){
        return ASKED;
    }

    public long getREVIEW() {
        return REVIEW;
    }
}
