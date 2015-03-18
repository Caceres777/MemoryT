package com.example.owen.pruebasliderfragment.ListViewItems;

import java.io.Serializable;

/**
 * Created by Owen on 18/03/2015.
 */
public class RowItemQuestion implements Serializable {

    private String pregunta;
    private String respuesta;
    private int fallos;
    private int aciertos;

    public RowItemQuestion(String pregunta, String respuesta, int fallos, int aciertos){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.fallos = fallos;
        this.aciertos = aciertos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
