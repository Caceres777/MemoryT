package com.example.owen.pruebasliderfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.WindowManager;


public class Initial extends Activity {

    //Button btn;
    FragmentManager fragmentmanager;
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_initial);

        // introducimos el primer fragmento a la pantalla principal
        fragmentmanager = getFragmentManager();
        ft = fragmentmanager.beginTransaction();

        final Start_frag startFrag = new Start_frag();
        ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right,R.animator.slide_in_left, R.animator.slide_out_right);
        ft.add(R.id.background_start, startFrag);
        ft.commit();
    }


}
