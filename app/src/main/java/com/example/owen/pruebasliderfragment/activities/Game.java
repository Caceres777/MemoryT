package com.example.owen.pruebasliderfragment.activities;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.data.DataSource;
import com.example.owen.pruebasliderfragment.fragments.GameQuestion_frag;

import java.util.ArrayList;

public class Game extends ActionBarActivity {

    private final static int NUM_PREGUNTAS = 5;
    int id_tema, contador = 0;
    ArrayList<BeanQuestions> preguntas;
    ArrayList<String> respuestasIncorrectos;
    android.app.FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        preguntas = new ArrayList<BeanQuestions>();

        id_tema = getIntent().getIntExtra("tema", 0);
        contador = 0;

        preguntas = new DataSource(this).getPreguntas(id_tema);
        respuestasIncorrectos = new DataSource(this).getRespuestasIncorrectas(id_tema, preguntas.get(contador).getID());
        // creamos la primera pregunta
        ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
        GameQuestion_frag frag = new GameQuestion_frag();
        frag.defineQuestionAndAnswers(preguntas.get(contador), respuestasIncorrectos);
        contador++;
        ft.replace(R.id.game_container,frag);
        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // creara la siguiente pregunta
    public void setNewQuestion(){
        if(contador < preguntas.size()) {
            android.app.FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            //respuestasIncorrectos = new DataSource(this).getRespuestasIncorrectas(preguntas.get(contador).getID_QUESTION());
            //respuestaCorrecta = new DataSource(this).getRespuestaCorrecta(preguntas.get(contador).getID_QUESTION());
            ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
            GameQuestion_frag frag = new GameQuestion_frag();
            //frag.defineQuestionAndAnswers(preguntas.get(contador), respuestasIncorrectos, respuestaCorrecta);
            contador++;
            ft.replace(R.id.game_container, frag);
            ft.addToBackStack(null);
            ft.commit();
        }
    }


    public void setCorrectOrWrong(boolean aux){
        int wrong = preguntas.get(contador-1).getWRONG();
        if(!aux)
            wrong++;
        new DataSource(this).updatePregunta(preguntas.get(contador - 1), wrong);
    }
}
