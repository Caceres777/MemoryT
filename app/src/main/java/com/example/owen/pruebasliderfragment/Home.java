package com.example.owen.pruebasliderfragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;

import com.parse.ParseUser;


public class Home extends ActionBarActivity {

    Button my_courses, find_courses, vs, profile, badges;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // icon set on action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_logo);
        // font style
        //Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/BrushScriptStd.otf");
        my_courses = (Button)findViewById(R.id.menu_my_courses);
        find_courses = (Button)findViewById(R.id.menu_find_courses);
        vs = (Button)findViewById(R.id.menu_vs);
        profile = (Button)findViewById(R.id.menu_profile);
        badges = (Button)findViewById(R.id.menu_badges);
        // Setting font style
/*
        my_courses.setTypeface(tf);
        find_courses.setTypeface(tf);
        vs.setTypeface(tf);
        profile.setTypeface(tf);
        badges.setTypeface(tf);
*/
        // set the content view

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()){
            case R.id.option1:
                ParseUser.getCurrentUser().logOut();
                Intent intent = new Intent(this, Initial.class);
                Intent mainIntent = IntentCompat.makeRestartActivityTask(intent.getComponent());
                startActivity(mainIntent);
                overridePendingTransition(R.animator.left_in, R.animator.left_out);
                break;
        }



        return super.onOptionsItemSelected(item);
    }

}
