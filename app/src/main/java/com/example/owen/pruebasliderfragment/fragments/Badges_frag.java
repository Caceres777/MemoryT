package com.example.owen.pruebasliderfragment.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.BadgesAdapter;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.RowItemMenu;
import com.example.owen.pruebasliderfragment.RowItemsBadges;
import com.example.owen.pruebasliderfragment.SubrowItemBadges;

import java.util.ArrayList;


public class Badges_frag extends Fragment {

    ArrayList<RowItemsBadges> grupos = new ArrayList<RowItemsBadges>();
    String[] cursos = {"Veterinaria","Ingles","Capitales"};
    int[] cursos_img = {R.drawable.user_img, R.drawable.user_img, R.drawable.user_img};

    public Badges_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_badges_frag, container, false);

        for (int i = 0; i < cursos.length; i++) {
            RowItemsBadges item = new RowItemsBadges(cursos_img[i], cursos[i]);
            item.children.add(new SubrowItemBadges(R.drawable.badgegold, "esto es un badge yiha"));
            item.children.add(new SubrowItemBadges(R.drawable.badgesilver, "esto es un badge menos guay yiha"));
            grupos.add(item);
        }

        ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listViewBadges);
        BadgesAdapter adapter = new BadgesAdapter(getActivity(), grupos);
        listView.setAdapter(adapter);

        return v;
    }
}
