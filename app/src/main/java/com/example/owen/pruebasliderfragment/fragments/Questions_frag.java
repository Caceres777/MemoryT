package com.example.owen.pruebasliderfragment.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanPreguntas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanRespuestas;
import com.example.owen.pruebasliderfragment.JavaBean.BeanTemas;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemQuestion;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.activities.Game;
import com.example.owen.pruebasliderfragment.adapters.QuestionAdapter;
import com.example.owen.pruebasliderfragment.data.DataSource;

import java.util.ArrayList;


public class Questions_frag extends Fragment {

    BeanTemas tema;
    ListView listView;
    Button startGame;
    QuestionAdapter adapter;
    ArrayList<RowItemQuestion> questions;
    ArrayList<BeanPreguntas> ob;

    public Questions_frag() {

    }

    public void setTema(BeanTemas tema){
        this.tema = tema;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RemoteDataTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_questions_frag, container, false);
        startGame = (Button) v.findViewById(R.id.Button_StartGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start game here (Activity Game)
                Intent intent = new Intent(getActivity(), Game.class);
                intent.putExtra("tema", tema.getID_THEME());
                startActivity(intent);
                getActivity().overridePendingTransition(R.animator.left_in, R.animator.left_out);
            }
        });
        return v;
    }


    // RemoteDataTask AsyncTask
    class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            questions = new ArrayList<RowItemQuestion>();
            ob = new DataSource(getActivity()).getPreguntas(tema.getID_THEME());
            for (BeanPreguntas question : ob) {
                BeanRespuestas respuesta = new DataSource(getActivity()).getRespuestaCorrecta(question.getID_QUESTION());
                RowItemQuestion item = new RowItemQuestion(question.getTEXT(), respuesta.getTEXT(), question.getWRONG(), question.getRIGHT());
                questions.add(item);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView = (ListView) getActivity().findViewById(R.id.QuestionListView);
            // Pass the results into ListViewAdapter.java
            adapter = new QuestionAdapter(getActivity(), R.layout.question_item, questions);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
        }
    }

}
