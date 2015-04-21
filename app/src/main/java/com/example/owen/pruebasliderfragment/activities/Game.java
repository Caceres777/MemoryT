package com.example.owen.pruebasliderfragment.activities;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.owen.pruebasliderfragment.Controller;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.SM2;
import com.example.owen.pruebasliderfragment.data.DataSource;
import com.example.owen.pruebasliderfragment.fragments.GameFinishScreen_frag;
import com.example.owen.pruebasliderfragment.fragments.GameTestQuestion_frag;
import com.example.owen.pruebasliderfragment.fragments.GameStudy_frag;
import com.example.owen.pruebasliderfragment.fragments.GameWriteQuestion_frag;

import java.util.ArrayList;
import java.util.List;

public class Game extends ActionBarActivity {

    private int porcetange = 0; // usado en la pantalla final de game
    private int wrong = 0;
    private final static int NUM_PREGUNTAS = 15; // numero de preguntas realizadas
    private final static double EF_QUESTION_TIPE = 1.7; // al superar este EF las preguntas pasan a tipo write
    private SM2 sm2; // algorithm que devuelve el dia de repaso y el nuevo EF
    int id_tema, id_course, cont = 0;
    ArrayList<BeanQuestions> preguntas;
    List<String> respuestasIncorrectas;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
            //respuestasIncorrectas = new DataSource(this).getRespuestasIncorrectas(id_tema, preguntas.get(cont).getID());
            respuestasIncorrectas = new Controller(this).getWrongAnswers(id_tema, preguntas.get(cont).getID());
            // comprobamos si se a preguntado con aterioridad
            if(preguntas.get(cont).getASKED() > 0) {
                // comprobar si el EF de la pregunta es mayor que 2, en caso de ser asi introducir preguntas escritas
                if(preguntas.get(cont).getEF() >= EF_QUESTION_TIPE ) {
                    // mostramos la pantalla de write
                    setWriteQuestionScreen(cont);
                }else{
                    setTetsQuestionScreen(cont);
                }
                cont++;
            }else {
                // mostramos la pantalla de estudio
                setLearningScreen();
            }
        }else{
            setLastGameScreen();
        }
    }


    public void setLastGameScreen(){
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
        GameFinishScreen_frag frag = new GameFinishScreen_frag();
        ft.replace(R.id.game_container, frag);
        ft.addToBackStack(null);
        ft.commit();
    }




    public void setWriteQuestionScreen(int pos){
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
        GameWriteQuestion_frag frag = new GameWriteQuestion_frag(preguntas.get(pos));
        ft.replace(R.id.game_container, frag);
        ft.addToBackStack(null);
        ft.commit();
    }




    public void setTetsQuestionScreen(int pos){
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
        GameTestQuestion_frag frag = new GameTestQuestion_frag();
        frag.defineQuestionAndAnswers(preguntas.get(pos), respuestasIncorrectas);
        ft.replace(R.id.game_container, frag);
        ft.addToBackStack(null);
        ft.commit();
    }




    public void setLearningScreen(){
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
        GameStudy_frag frag = new GameStudy_frag(this, preguntas.get(cont).getTEXT1(), preguntas.get(cont).getTEXT2());
        ft.replace(R.id.game_container, frag);
        ft.addToBackStack(null);
        ft.commit();
        setAsked();
    }


    public void setCorrect(){
        controller = new Controller(this);
        updateEF(cont-1,5);
        new Thread(new Runnable() {
            public void run() {
                controller.updateQuestionTotal(preguntas.get(cont - 1));
            }
        }).start();

    }

    public void setWrong(){
        wrong++;
        porcetange = wrong*100/cont;
        preguntas.get(cont-1).setWRONG(preguntas.get(cont-1).getWRONG()+1);
        updateEF(cont - 1, 0);
        controller = new Controller(this);
        new Thread(new Runnable() {
            public void run() {
                controller.updateQuestionTotal(preguntas.get(cont - 1));
            }
        }).start();

    }


    public void setAsked(){
        controller = new Controller(this);
        preguntas.get(cont).setASKED(1);
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



    public void updateEF(int pos, int qr){
        double ef = preguntas.get(pos).getEF();
        sm2 = new SM2(ef, qr);
        preguntas.get(pos).setTOTAL(preguntas.get(pos).getTOTAL()+1);
        preguntas.get(pos).setEF(sm2.getNewEFactor());
        preguntas.get(pos).setREVIEW(sm2.getNextInterval(preguntas.get(pos).getTOTAL()));
    }


}
