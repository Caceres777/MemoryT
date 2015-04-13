package com.example.owen.pruebasliderfragment.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCourse;
import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemChapter;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.ChaptersAdapter;
import com.example.owen.pruebasliderfragment.data.DataSource;

import java.util.ArrayList;
import java.util.List;


public class Chapters_frag extends Fragment {

    BeanCourse course;
    // para la busqueda
    ArrayList<RowItemChapter> grupos;
    List<BeanChapter> ob;
    ChaptersAdapter adapter;
    ExpandableListView listView;

    public Chapters_frag() {
        // Required empty public constructor
    }

    public void setCourse(BeanCourse course){
        this.course = course;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RemoteDataTask().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chapters_frag, container, false);
        return v;
    }


    // RemoteDataTask AsyncTask
    class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            grupos = new ArrayList<RowItemChapter>();
            ob = new DataSource(getActivity()).getTemas(course.getID());
            for (BeanChapter tema : ob) {
                RowItemChapter item = new RowItemChapter(tema.getNAME() , new SubrowItemChapter(10 , 5, tema.getACCURACY()), tema.getPROGRESS());
                grupos.add(item);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView = (ExpandableListView) getActivity().findViewById(R.id.listaChapters);
            // Pass the results into ListViewAdapter.java
            adapter = new ChaptersAdapter(getActivity(), grupos, ob);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
        }
    }



}
