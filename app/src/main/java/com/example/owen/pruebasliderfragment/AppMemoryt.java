package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 28/01/2015.
 */

import android.app.Application;
import com.parse.Parse;

public class AppMemoryt extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "eUm1h1r7STn62J6CMZpISBQCtM7izmp8b001Udab", "g3qvGnhMjsVrMGn03ZkcdmIGBvUPEDIoTJUMyrxP");

        //ParseUser.enableAutomaticUser();
        //ParseACL defaultACL = new ParseACL();
    }

}