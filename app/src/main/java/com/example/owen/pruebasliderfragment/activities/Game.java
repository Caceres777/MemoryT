package com.example.owen.pruebasliderfragment.activities;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.owen.pruebasliderfragment.Controller;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.data.DataSource;
import com.example.owen.pruebasliderfragment.fragments.GameQuestion_frag;
import com.example.owen.pruebasliderfragment.fragments.GameStudy_frag;

import java.util.ArrayList;

public class Game extends ActionBarActivity {

    private int porcetange = 0;
    private int wrong = 0;
    private final static int NUM_PREGUNTAS = 5;
    int id_tema, id_course, cont = 0;
    ArrayList<BeanQuestions> preguntas;
    ArrayList<String> respuestasIncorrectas;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        preguntas = new ArrayList<BeanQuestions>();

        id_tema = getIntent().getIntExtra("chapter", 0);
        id_course = getIntent().getIntExtra("course", 0);
        cont = 0;

        preguntas = new DataSource(this).getPreguntas(id_tema);
        respuestasIncorrectas = new DataSource(this).getRespuestasIncorrectas(id_tema, preguntas.get(cont).getID());
        // creamos la primera pregunta
        setNewQuestion();
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

    public void setNewQuestion(){
        if(cont < preguntas.size()) {
            android.app.FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            respuestasIncorrectas = new DataSource(this).getRespuestasIncorrectas(id_tema, preguntas.get(cont).getID());
            // comprobamos si se a preguntado con aterioridad
            if(preguntas.get(cont).getASKED() > 0) {
                // comprobar si el EF de la pregunta es mayor que 2, en caso de ser asi introducir preguntas escritas
                ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
                GameQuestion_frag frag = new GameQuestion_frag();
                frag.defineQuestionAndAnswers(preguntas.get(cont), respuestasIncorrectas);
                ft.replace(R.id.game_container, frag);
                cont++;
            }else {
                // mostramos la pantalla de estudio
                ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
                GameStudy_frag frag = new GameStudy_frag(this, preguntas.get(cont).getTEXT1(), preguntas.get(cont).getTEXT2());
                ft.replace(R.id.game_container, frag);
                preguntas.get(cont).setASKED(1);
                setAsked();
            }
            ft.addToBackStack(null);
            ft.commit();
        }
    }


    public void setLastGameScreen(){
        // pantalla final del juego con puntuaciones y boton para volver

    }


    public void setCorrect(){
        controller = new Controller(this);
        new Thread(new Runnable() {
            public void run() {
                controller.updateQuestionTotal(preguntas.get(cont - 1), 0);
            }
        }).start();

    }

    public void setWrong(){
        wrong++;
        porcetange = wrong*100/cont;
        controller = new Controller(this);
        new Thread(new Runnable() {
            public void run() {
                controller.updateQuestionTotal(preguntas.get(cont - 1), 1);
            }
        }).start();

    }


    public void setAsked(){
        controller = new Controller(this);
        new Thread(new Runnable() {
            public void run() {
                controller.updateQuestionAsked(preguntas.get(cont));
            }
        }).start();
    }


    @Override
    public void onBackPressed(){
        new Thread(new Runnable() {
            public void run() {
                controller.updateChapter(id_tema);
                controller.updateCourse(id_course);
            }
        }).start();
        super.onBackPressed();
    }

}
