package com.example.owen.pruebasliderfragment.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.example.owen.pruebasliderfragment.Controller;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

public class SearchCourses_frag extends Fragment{
    ArrayList<RowItemSearchCourses> grupos;
    List<ParseObject> ob;
    LinearLayout progressBar;
    SearchCoursesAdapter adapter;
    ExpandableListView listView;


    public SearchCourses_frag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_courses, container, false);
        listView = (ExpandableListView) v.findViewById(R.id.listaBuscarCurso);
        progressBar = (LinearLayout) v.findViewById(R.id.HeaderProgress);
        new RemoteDataTask().execute();
        return v;
    }




    // RemoteDataTask AsyncTask
    class RemoteDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            grupos = new ArrayList<RowItemSearchCourses>();
            ob = new Controller(getActivity()).getSearchCourses();
            for (ParseObject course : ob) {
                ParseFile image = (ParseFile) course.get("Image");
                RowItemSearchCourses item = new RowItemSearchCourses(setCourseImg(image),(String) course.get("Name"),new SubrowItemSearchCourses((String) course.get("Definition"), 5));
                grupos.add(item);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            adapter = new SearchCoursesAdapter(getActivity(), grupos, ob);
            listView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }


        public Bitmap setCourseImg(ParseFile data){
            Bitmap bitmap = null;
            if(data != null) {
                try {
                    byte[] img = data.getData();
                    bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                    bitmap = Bitmap.createScaledBitmap(bitmap, 180, 180, true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
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
