package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 28/01/2015.
 */

import android.app.Application;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class AppMemoryt extends Application{

    ArrayList<RowItemSearchCourses> grupos;
    List<ParseObject> ob = null;


    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "eUm1h1r7STn62J6CMZpISBQCtM7izmp8b001Udab", "g3qvGnhMjsVrMGn03ZkcdmIGBvUPEDIoTJUMyrxP");
        new RemoteDataTask().execute();
    }

    /**
     * Clase encargada de buscar los datos de los cursos desde parse
     */
    // RemoteDataTask AsyncTask
    class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            grupos = new ArrayList<RowItemSearchCourses>();
            try {
                // Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Course");
                ob = query.find();

            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

        }

    }


    public ParseObject getCourseByID(int index){
        return ob.get(index);
    }


    public List<ParseObject> getCourses(){
        return ob;
    }

}