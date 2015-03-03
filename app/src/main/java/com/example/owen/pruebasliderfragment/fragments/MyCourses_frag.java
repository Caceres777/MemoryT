package com.example.owen.pruebasliderfragment.fragments;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemSearchCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.MyCoursesAdapter;
import com.example.owen.pruebasliderfragment.adapters.SearchCoursesAdapter;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class MyCourses_frag extends Fragment {
/*
    ArrayList<RowItemMyCourses> grupos = new ArrayList<RowItemMyCourses>();
    String[] cursos = {"Veterinaria","Ingles","Capitales","embalsamar", "tocarte los huevos"};
    int[] cursos_img = {R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img, R.drawable.user_img};
*/
    ArrayList<RowItemMyCourses> grupos;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    MyCoursesAdapter adapter;


    public MyCourses_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RemoteDataTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_my_courses_frag, container, false);
        /*
        for (int i = 0; i < cursos.length; i++) {
            String def = "Definicion del curso en cuestion, con el aprenderas un monton de cosas muchas mucha" +
                    "muchas cosas";
            RowItemMyCourses item = new RowItemMyCourses(cursos_img[i], cursos[i], new SubrowItemMyCourses(def, 5, 2), 40);
            grupos.add(item);
        }

        ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listaMyCurso);
        Display newDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();
        listView.setIndicatorBounds(width-50,width);
        MyCoursesAdapter adapter = new MyCoursesAdapter(getActivity(), grupos);
        listView.setAdapter(adapter);
        */
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
            mProgressDialog.setTitle("Searching for your Courses");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create the array
            grupos = new ArrayList<RowItemMyCourses>();
            try {
                //String userID = ParseUser.getCurrentUser().getObjectId();
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Progreso_Cursos");
                query.whereEqualTo("UserID",ParseUser.getCurrentUser());
                ob = query.find();
                for (ParseObject course : ob) {
                    String courseID = course.getString("CourseID");
                    Log.d("CourseID", "El id es : "+courseID);
                    ParseQuery<ParseObject> queryCourse = new ParseQuery<ParseObject>("Course");
                                       queryCourse.whereEqualTo("objectId",courseID );
                    ParseObject mycourse =  queryCourse.find().get(0);

                    Log.d("NOMBRE", (String) mycourse.get("Name"));
                    ParseFile image = (ParseFile) mycourse.get("Image");
                    RowItemMyCourses item = new RowItemMyCourses(setCourseImg(image),(String) mycourse.get("Name"),new SubrowItemMyCourses((String) mycourse.get("Definition"), 2, 5),course.getInt("Progress"));
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
            ExpandableListView listView = (ExpandableListView) getActivity().findViewById(R.id.listaMyCurso);
            // Pass the results into ListViewAdapter.java
            adapter = new MyCoursesAdapter(getActivity(), grupos);
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

}
