package com.example.owen.pruebasliderfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.parse.ParseUser;


public class Memoryt_home extends ActionBarActivity {

    Navigation_drawer_frag menuFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoryt_home);
        // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // icon set on action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_logo);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_memoryt_hom, menu);
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
            case R.id.option2:
                menuFrag = new Navigation_drawer_frag();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right,R.animator.slide_in_left, R.animator.slide_out_right);
                ft.add(R.id.Home, menuFrag);
                ft.addToBackStack(null);
                ft.commit();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }
        else {
            super.onBackPressed();
        }
    }

}
