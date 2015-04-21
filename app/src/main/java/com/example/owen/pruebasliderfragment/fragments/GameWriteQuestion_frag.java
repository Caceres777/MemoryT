package com.example.owen.pruebasliderfragment.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.activities.Game;


public class GameWriteQuestion_frag extends Fragment {

    BeanQuestions question;
    EditText editText;
    TextView textView;
    ImageView button;

    public GameWriteQuestion_frag(BeanQuestions question) {
        // Required empty public constructor
        this.question = question;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_write_question_frag, container, false);

        textView = (TextView) v.findViewById(R.id.pregunta);
        textView.setText(question.getTEXT1());
        editText = (EditText) v.findViewById(R.id.respuesta);
        button = (ImageView) v.findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals(question.getTEXT2())){
                    ((Game)getActivity()).setCorrect();
                }else
                    ((Game)getActivity()).setWrong();
                ((Game)getActivity()).setLearningScreen();
            }
        });

        return v;
    }

}
