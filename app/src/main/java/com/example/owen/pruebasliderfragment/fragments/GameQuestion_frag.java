package com.example.owen.pruebasliderfragment.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.GameAnswerAdapter;

import java.util.ArrayList;


public class GameQuestion_frag extends Fragment {

    private static final int NUM_ANSWERS = 4;
    BeanQuestions beanpregunta;
    ArrayList<String> respuestasIncorrectas;
    ArrayList<String> answers;
    TextView pregunta;


    public GameQuestion_frag() {
        // Required empty public constructor
    }

    public void defineQuestionAndAnswers(BeanQuestions beanpregunta, ArrayList<String> respuestasIncorrectas){
        this.beanpregunta = beanpregunta;
        this.respuestasIncorrectas = respuestasIncorrectas;
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

        pregunta.setText(beanpregunta.getTEXT1());
        int cont = 0;
        int correct = (int)(Math.random()*NUM_ANSWERS);
        answers = new ArrayList<String>();
        for(int i = 0 ; i < NUM_ANSWERS; i++){
            if(correct == i)
                answers.add(beanpregunta.getTEXT2());
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
