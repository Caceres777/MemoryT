package com.example.owen.pruebasliderfragment.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.owen.pruebasliderfragment.ImageHelper;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemMyCourses;
import com.example.owen.pruebasliderfragment.ListViewItems.SubrowItemMyCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.adapters.MyCoursesAdapter;
import com.example.owen.pruebasliderfragment.data.Ayudante;
import com.example.owen.pruebasliderfragment.parse.DataEntry.CourseEntry;
import com.example.owen.pruebasliderfragment.parse.DataEntry.Progreso_cursosEntry;
import com.example.owen.pruebasliderfragment.parse.ParseHelper;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class MyCourses_frag extends Fragment {

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
        setHasOptionsMenu(true);
        new RemoteDataTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_my_courses_frag, container, false);
        //setAdapterFromLocal();
        //setAdapterFromParse();

        //ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listaMyCurso);
        //MyCoursesAdapter adapter = new MyCoursesAdapter(getActivity(), grupos, ob);
        //listView.setAdapter(adapter);

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
            CourseEntry tabla = new CourseEntry();
            ParseHelper parseHelper = new ParseHelper();
            ob = parseHelper.getAllMyCourses(ParseUser.getCurrentUser());
            if(ob != null) {
                // fallo en coger los datos de la tabla
                for (ParseObject myCourse : ob) {
                    ParseObject curso = (ParseObject) myCourse.get(new Progreso_cursosEntry().getCourseID());
                    ParseFile image = (ParseFile) curso.get(tabla.getImage());
                    // comprobar el tipo de dato introducidos en RowItemCourses
                    RowItemMyCourses item = new RowItemMyCourses(new ImageHelper().parseFiletoBitmap(image), curso.getString(tabla.getName()), new SubrowItemMyCourses(curso.getString(tabla.getDefinition()), 5, 2), (Integer) myCourse.get(new Progreso_cursosEntry().getProgress()));
                    grupos.add(item);
                }
            }else{
                Toast.makeText(getActivity(),"No courses",Toast.LENGTH_LONG);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            ExpandableListView listView = (ExpandableListView) getActivity().findViewById(R.id.listaMyCurso);
            // Pass the results into ListViewAdapter.java
            adapter = new MyCoursesAdapter(getActivity(), grupos, ob);
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.mycourses , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                new RemoteDataTask().execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void setAdapterFromLocal(){
        Ayudante SQLhelper = new Ayudante(getActivity());
        SQLhelper.getCursos(getActivity());
    }


    public void setAdapterFromParse(){
        CourseEntry tabla = new CourseEntry();
        ParseHelper parseHelper = new ParseHelper();
        ob = parseHelper.getAllMyCourses(ParseUser.getCurrentUser());
        grupos = new ArrayList<RowItemMyCourses>();
        if(ob != null) {
            // fallo en coger los datos de la tabla
            for (ParseObject myCourse : ob) {
                //Log.d("PARSECURSO", myCourse.getString(new Progreso_cursosEntry().getFinished()));
                ParseObject curso = (ParseObject) myCourse.get(new Progreso_cursosEntry().getCourseID());
                Toast.makeText(getActivity(),"Mensaje: "+curso.getObjectId(), Toast.LENGTH_LONG);
                ParseFile image = curso.getParseFile(tabla.getImage());
                RowItemMyCourses item = new RowItemMyCourses(new ImageHelper().parseFiletoBitmap(image), curso.getString(tabla.getName()), new SubrowItemMyCourses(curso.getString(tabla.getDefinition()), 5, 2), myCourse.getInt(new Progreso_cursosEntry().getProgress()));
                grupos.add(item);
            }
        }else{
            Toast.makeText(getActivity(),"No courses",Toast.LENGTH_LONG);
        }
    }

}
