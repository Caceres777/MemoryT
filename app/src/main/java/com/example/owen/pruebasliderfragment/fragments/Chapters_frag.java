package com.example.owen.pruebasliderfragment.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.AppMemoryt;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.ChaptersAdapter;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class Chapters_frag extends Fragment {

    ParseObject course;
    // para la busqueda
    ArrayList<RowItemChapter> grupos;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ChaptersAdapter adapter;
    ExpandableListView listView;

    public Chapters_frag() {
        // Required empty public constructor
    }

    public void setCourse(ParseObject course){
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
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(getActivity());
            // Set progressdialog title
            mProgressDialog.setTitle("Looking for Chapters");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            grupos = new ArrayList<RowItemChapter>();
            try {

                // Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Chapters");
                query.whereEqualTo("Curso", course);
                query.orderByAscending("position");
                ob = query.find();
                for (ParseObject chapter : ob) {
                    // Locate images in flag column
                    RowItemChapter item = new RowItemChapter((String) chapter.get("name"), new SubrowItemChapter(10 , 5, 80), 80);
                    grupos.add(item);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView = (ExpandableListView) getActivity().findViewById(R.id.listaChapters);
            // Pass the results into ListViewAdapter.java
            adapter = new ChaptersAdapter(getActivity(), grupos);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }

}
