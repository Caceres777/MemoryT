package com.example.owen.pruebasliderfragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseUser;
import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // animates the logo
        setContentView(R.layout.activity_splash_screen);

        TextView charging = (TextView)findViewById(R.id.textView);
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/BrushScriptStd.otf");
        charging.setTypeface(tf);
        animate_logo();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                // check if the user is already logged
                ParseUser currentUser = ParseUser.getCurrentUser();
                if( currentUser != null){
                    startActivity(new Intent(SplashScreen.this, Home.class));
                }else{
                    startActivity(new Intent(SplashScreen.this, Initial.class));
                }

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }



    private void animate_logo(){
        ImageView animationLogo = (ImageView)findViewById(R.id.animation);
        final AnimationDrawable ad = (AnimationDrawable)animationLogo.getDrawable();
        ad.start();

    }
}
