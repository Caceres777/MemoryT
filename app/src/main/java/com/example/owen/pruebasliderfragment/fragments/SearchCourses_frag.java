package com.example.owen.pruebasliderfragment.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMenu;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.adapters.MenuAdapter;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchCourses_frag extends Fragment{

    ArrayList<RowItemSearchCourses> grupos = new ArrayList<RowItemSearchCourses>();
    String[] cursos = {"Veterinaria","Ingles","Capitales","embalsamar", "tocarte los huevos"};
    int[] cursos_img = {R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img};


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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_courses, container, false);

        for (int i = 0; i < cursos.length; i++) {
            String def = "Definicion del curso en cuestion, con el aprenderas un monton de cosas muchas mucha" +
                    "muchas cosas";
            RowItemSearchCourses item = new RowItemSearchCourses(cursos_img[i], cursos[i], new SubrowItemSearchCourses(def, 5));
            grupos.add(item);
        }

        ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listaBuscarCurso);
        SearchCoursesAdapter adapter = new SearchCoursesAdapter(getActivity(), grupos);
        listView.setAdapter(adapter);

        return v;
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
        getActivity().invalidateOptionsMenu();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast t = Toast.makeText(getActivity(), "Busqueda", Toast.LENGTH_LONG);
                t.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
