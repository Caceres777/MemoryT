package com.example.owen.pruebasliderfragment.ListViewItems;

import java.io.Serializable;

/**
 * Created by Owen on 18/02/2015.
 */
public class SubrowItemMyCourses implements Serializable {
    private String definition;
    private int num_temas;
    private int num_temas_completados;

    public SubrowItemMyCourses(String definition, int num_temas, int num_temas_completados){
        this.definition = definition;
        this.num_temas = num_temas;
        this.num_temas_completados = num_temas_completados;
    }

    public int getNum_temas() {
        return num_temas;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setNum_temas(int num_temas) {
        this.num_temas = num_temas;
    }

    public void setNum_temas_completados(int num_temas_completados) {
        this.num_temas_completados = num_temas_completados;
    }

    public int getNum_temas_completados() {
        return num_temas_completados;
    }
}
