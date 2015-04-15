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

import com.example.owen.pruebasliderfragment.Controller;
import com.example.owen.pruebasliderfragment.JavaBean.BeanQuestions;
import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemQuestion;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.activities.Game;
import com.example.owen.pruebasliderfragment.adapters.QuestionAdapter;
import com.example.owen.pruebasliderfragment.data.DataSource;

import java.util.ArrayList;
import java.util.List;


public class Questions_frag extends Fragment {

    BeanChapter tema;
    ListView listView;
    Button startGame;
    QuestionAdapter adapter;
    ArrayList<RowItemQuestion> questions;
    List<BeanQuestions> ob;

    public Questions_frag() {

    }

    public void setTema(BeanChapter tema){
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
                intent.putExtra("chapter", tema.getID());
                intent.putExtra("course", tema.getFK_ID_COURSE());
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
            ob = new Controller(getActivity()).getQuestionsFromLocal(tema.getID());
            for (BeanQuestions question : ob) {
                RowItemQuestion item = new RowItemQuestion(question.getTEXT1(), question.getTEXT2(), question.getWRONG(), question.getTOTAL()-question.getWRONG());
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
