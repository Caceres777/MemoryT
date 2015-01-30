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
        ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
        ft.add(R.id.background_start, startFrag);
        ft.commit();

        ImageView logo = (ImageView)findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),Home.class));
                // makes an animation for the transition of the activities
                overridePendingTransition(R.animator.left_in, R.animator.left_out);
            }
        });
    }




}
