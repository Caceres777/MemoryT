package com.example.owen.pruebasliderfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


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
        ft.setCustomAnimations(R.animator.slide_in_down, R.animator.slide_out_up);
        ft.add(R.id.background_start, startFrag);
        ft.commit();

        ImageView logo = (ImageView)findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Home.class);
                startActivity(i);
            }
        });
    }


}
