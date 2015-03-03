package com.example.owen.pruebasliderfragment.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.owen.pruebasliderfragment.ImageHelper;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class SearchCourses_frag extends Fragment{
    ArrayList<RowItemSearchCourses> grupos;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    SearchCoursesAdapter adapter;
    ExpandableListView listView;


    public SearchCourses_frag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RemoteDataTask().execute();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_courses, container, false);
        return v;
    }




    // RemoteDataTask AsyncTask
    class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(getActivity());
            // Set progressdialog title
            mProgressDialog.setTitle("Looking for Courses");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            grupos = new ArrayList<RowItemSearchCourses>();
            try {
                // Locate the class table named "Country" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Course");
                ob = query.find();
                for (ParseObject course : ob) {
                    // Locate images in flag column
                    ParseFile image = (ParseFile) course.get("Image");
                    RowItemSearchCourses item = new RowItemSearchCourses(setCourseImg(image),(String) course.get("Name"),new SubrowItemSearchCourses((String) course.get("Definition"), 5));
                    grupos.add(item);
                }
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView = (ExpandableListView) getActivity().findViewById(R.id.listaBuscarCurso);
            // Pass the results into ListViewAdapter.java
            adapter = new SearchCoursesAdapter(getActivity(), grupos);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }


        public Bitmap setCourseImg(ParseFile data){
            Bitmap bitmap = null;
            if(data != null) {
                try {
                    byte[] img = data.getData();
                    bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                    bitmap = Bitmap.createScaledBitmap(bitmap, 180, 180, true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }

    }

    /**
     * Ya que alamacenamos los cursos de parse dentro del fragmento, hacemos uso de este
     * metodo para que el listener tenga acceso a el sin necesidad de volver a hacer otra
     * consulta
     * @param index
     * @return
     */
    public ParseObject getCourseByID(int index){
        return ob.get(index);
    }

}
