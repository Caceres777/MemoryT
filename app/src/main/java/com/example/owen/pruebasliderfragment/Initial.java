package com.example.owen.pruebasliderfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.WindowManager;


public class Initial extends Activity {

    FragmentManager fragmentmanager;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // set the content view
        setContentView(R.layout.activity_initial);

        // we introduce the first fragment into the activity
        fragmentmanager = getFragmentManager();
        ft = fragmentmanager.beginTransaction();

        final Start_frag startFrag = new Start_frag();
        ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
        ft.add(R.id.background_start, startFrag);
        ft.commit();
    }




}
