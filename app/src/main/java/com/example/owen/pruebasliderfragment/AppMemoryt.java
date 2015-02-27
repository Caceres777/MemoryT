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
        Parse.initialize(this, "LqQzEG40XVLk82oLyFihkOMYzuZwfNydnto0XDrO", "uSYuprVVtMo3wJonlosXxxBL25gUFLIE8pyA5vZX");

        //ParseUser.enableAutomaticUser();
        //ParseACL defaultACL = new ParseACL();
    }

}