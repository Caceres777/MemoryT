package com.example.owen.pruebasliderfragment.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanPreguntas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanRespuestas;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.GameAnswerAdapter;
import com.example.owen.pruebasliderfragment.adapters.QuestionAdapter;

import java.util.ArrayList;


public class GameQuestion_frag extends Fragment {

    private static final int NUM_ANSWERS = 4;
    BeanPreguntas beanpregunta;
    ArrayList<BeanRespuestas> respuestasIncorrectas;
    BeanRespuestas respuestaCorrecta;
    ArrayList<BeanRespuestas> answers;
    TextView pregunta;


    public GameQuestion_frag() {
        // Required empty public constructor
    }

    public void defineQuestionAndAnswers(BeanPreguntas beanpregunta, ArrayList<BeanRespuestas> respuestasIncorrectas, BeanRespuestas respuestaCorrecta){
        this.beanpregunta = beanpregunta;
        this.respuestasIncorrectas = respuestasIncorrectas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_game_question_frag, container, false);

        pregunta = (TextView) v.findViewById(R.id.pregunta);

        pregunta.setText(beanpregunta.getTEXT());
        int cont = 0;
        int correct = (int)(Math.random()*NUM_ANSWERS);
        answers = new ArrayList<BeanRespuestas>();
        for(int i = 0 ; i < NUM_ANSWERS; i++){
            if(correct == i)
                answers.add(respuestaCorrecta);
            else{
                answers.add(respuestasIncorrectas.get(cont));
                cont++;
            }
        }
        ListView listView = (ListView) v.findViewById(R.id.listViewAnswers);
        GameAnswerAdapter adapter = new GameAnswerAdapter(getActivity(), R.layout.question_item, answers, correct);
        listView.setAdapter(adapter);
        return v;
    }



}
