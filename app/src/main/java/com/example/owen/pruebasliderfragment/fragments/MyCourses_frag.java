package com.example.owen.pruebasliderfragment.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.IntentCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemMyCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.activities.Initial;
import com.example.owen.pruebasliderfragment.adapters.MyCoursesAdapter;
import com.parse.ParseUser;

import java.util.ArrayList;


public class MyCourses_frag extends Fragment {

    ArrayList<RowItemMyCourses> grupos = new ArrayList<RowItemMyCourses>();
    String[] cursos = {"Veterinaria","Ingles","Capitales","estudiar", "tocarte los huevos"};
    int[] cursos_img = {R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img};

    public MyCourses_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

        ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listaMyCurso);
        Display newDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();
        listView.setIndicatorBounds(width-50,width);
        MyCoursesAdapter adapter = new MyCoursesAdapter(getActivity(), grupos);
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
