package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 13/02/2015.
 */
public class SubrowItemSearchCourses {
    private String definition;
    private int num_temas;

    public SubrowItemSearchCourses(String definition, int num_temas){
        this.definition = definition;
        this.num_temas = num_temas;
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

}
