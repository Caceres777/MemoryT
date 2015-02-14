package com.example.owen.pruebasliderfragment.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;

import java.util.ArrayList;

public class SearchCourses_frag extends Fragment{

    ArrayList<RowItemSearchCourses> grupos = new ArrayList<RowItemSearchCourses>();
    String[] cursos = {"Veterinaria","Ingles","Capitales","embalsamar", "tocarte los huevos"};
    int[] cursos_img = {R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img};

    public SearchCourses_frag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {  super.onCreate(savedInstanceState);   }


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

}
