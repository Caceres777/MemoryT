package com.example.owen.pruebasliderfragment.fragments;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanCourse;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemMyCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.MyCoursesAdapter;
import com.example.owen.pruebasliderfragment.data.DataSource;

import java.util.ArrayList;


public class MyCourses_frag extends Fragment {

    ArrayList<RowItemMyCourses> grupos;
    ArrayList<BeanCourse> cursos;
    MyCoursesAdapter adapter;


    public MyCourses_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
        new RemoteDataTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_my_courses_frag, container, false);
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
            grupos = new ArrayList<RowItemMyCourses>();
            cursos = new DataSource(getActivity()).getCursos();
            if(cursos != null) {
                for (BeanCourse myCourse : cursos) {
                    RowItemMyCourses item = new RowItemMyCourses(BitmapFactory.decodeByteArray(myCourse.getIMAGE(), 0, myCourse.getIMAGE().length), myCourse.getNAME(), new SubrowItemMyCourses(myCourse.getDEFINITION(), 5, 2), myCourse.getPROGRESS());
                    grupos.add(item);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            ExpandableListView listView = (ExpandableListView) getActivity().findViewById(R.id.listaMyCurso);
            // Pass the results into ListViewAdapter.java
            adapter = new MyCoursesAdapter(getActivity(), grupos, cursos);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.mycourses , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                new RemoteDataTask().execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
