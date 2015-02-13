package com.example.owen.pruebasliderfragment.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.GrupoDeItemsSearchCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;

public class SearchCourses_frag extends Fragment{


    public SearchCourses_frag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {  super.onCreate(savedInstanceState);   }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_courses, container, false);

        return v;
    }

}
