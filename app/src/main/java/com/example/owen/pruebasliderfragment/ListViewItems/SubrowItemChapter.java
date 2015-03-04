package com.example.owen.pruebasliderfragment.ListViewItems;

/**
 * Created by Owen on 03/03/2015.
 */
public class SubrowItemChapter {

    private int num_palabras;
    private int num_palabras_aprendidas;
    private int accuracy;


    public SubrowItemChapter(int palabras, int palabras_aprendidas, int accuracy){
        num_palabras = palabras;
        num_palabras_aprendidas = palabras_aprendidas;
        this.accuracy = accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setNum_palabras(int num_palabras) {
        this.num_palabras = num_palabras;
    }

    public void setNum_palabras_aprendidas(int num_palabras_aprendidas) {
        this.num_palabras_aprendidas = num_palabras_aprendidas;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getNum_palabras() {
        return num_palabras;
    }

    public int getNum_palabras_aprendidas() {
        return num_palabras_aprendidas;
    }
}
