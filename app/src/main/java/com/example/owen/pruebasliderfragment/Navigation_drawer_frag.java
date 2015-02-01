package com.example.owen.pruebasliderfragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Navigation_drawer_frag extends Fragment {

    private String[] menuTitles;
    private Integer[] menuImages ={R.drawable.ic_action_vs,R.drawable.ic_action_vs,R.drawable.ic_action_vs
    ,R.drawable.ic_action_search,R.drawable.ic_action_courses,R.drawable.ic_action_settings};

    ListView listView;
    List<RowItem> rowItems;

    public Navigation_drawer_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_navigation_drawer_frag, container, false);
        menuTitles = getResources().getStringArray(R.array.Memoryt_menu_home);
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < menuTitles.length; i++) {
            RowItem item = new RowItem(menuImages[i], menuTitles[i]);
            rowItems.add(item);
        }
        ListView menu = (ListView)v.findViewById(R.id.Menu_listView);
        MenuAdapter adapter = new MenuAdapter(v.getContext(), R.layout.menu_item, rowItems);
        menu.setAdapter(adapter);
        return v;
    }

}