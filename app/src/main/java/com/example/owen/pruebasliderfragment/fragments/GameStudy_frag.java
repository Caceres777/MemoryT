package com.example.owen.pruebasliderfragment.fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.activities.Game;


public class GameStudy_frag extends Fragment {

    String question, answer;
    TextView respuesta, pregunta;
    ImageView siguiente;
    Context context;

    public GameStudy_frag(Context context, String question, String answer) {
        // Required empty public constructor
        this.context = context;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_study_frag, container, false);
        pregunta = (TextView)v.findViewById(R.id.pregunta);
        pregunta.setText(question);
        respuesta = (TextView)v.findViewById(R.id.respuesta);
        respuesta.setText(answer);
        siguiente = (ImageView)v.findViewById(R.id.next);
        siguiente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cuando le da a siguiente consideramos que la palabra ya esta aprendida
                ((Game)context).setNewQuestion();
            }
        });
        return v;
    }

}
