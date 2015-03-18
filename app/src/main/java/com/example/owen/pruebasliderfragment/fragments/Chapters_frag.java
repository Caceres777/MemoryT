package com.example.owen.pruebasliderfragment.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.AppMemoryt;
import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.JavaBean.BeanTemas;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.ChaptersAdapter;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;
import com.example.owen.pruebasliderfragment.data.DataSource;
import com.example.owen.pruebasliderfragment.parse.DataEntry.ChaptersEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.CourseEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.Progreso_ChaptersEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.Progreso_cursosEntry;
import com.example.owen.pruebasliderfragment.parse.ParseHelper;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class Chapters_frag extends Fragment {

    BeanCursos course;
    // para la busqueda
    ArrayList<RowItemChapter> grupos;
    List<BeanTemas> ob;
    ChaptersAdapter adapter;
    ExpandableListView listView;

    public Chapters_frag() {
        // Required empty public constructor
    }

    public void setCourse(BeanCursos course){
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
            Progreso_ChaptersEntry tabla2 = new Progreso_ChaptersEntry();
            ob = new DataSource(getActivity()).getTemas(course.getID_COURSE());
            grupos = new ArrayList<RowItemChapter>();
            for (BeanTemas tema : ob) {
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
