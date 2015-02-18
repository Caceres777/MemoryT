package com.example.owen.pruebasliderfragment.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemMyCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.MyCoursesAdapter;

import java.util.ArrayList;


public class MyCourses_frag extends Fragment {

    ArrayList<RowItemMyCourses> grupos = new ArrayList<RowItemMyCourses>();
    String[] cursos = {"Veterinaria","Ingles","Capitales","embalsamar", "tocarte los huevos"};
    int[] cursos_img = {R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img};

    public MyCourses_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_my_courses_frag, container, false);
        for (int i = 0; i < cursos.length; i++) {
            String def = "Definicion del curso en cuestion, con el aprenderas un monton de cosas muchas mucha" +
                    "muchas cosas";
            RowItemMyCourses item = new RowItemMyCourses(cursos_img[i], cursos[i], new SubrowItemMyCourses(def, 5, 2), 40);
            grupos.add(item);
        }

        ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listaBuscarCurso);
        MyCoursesAdapter adapter = new MyCoursesAdapter(getActivity(), grupos);
        listView.setAdapter(adapter);
        return v;
    }

}
