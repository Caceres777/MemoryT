package com.example.owen.pruebasliderfragment.adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owen.pruebasliderfragment.AppMemoryt;
import com.example.owen.pruebasliderfragment.ImageHelper;
import com.example.owen.pruebasliderfragment.JavaBean.BeanCursos;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemSearchCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.data.Ayudante;
import com.example.owen.pruebasliderfragment.data.DataSource;
import com.example.owen.pruebasliderfragment.fragments.SearchCourses_frag;
import com.example.owen.pruebasliderfragment.parse.ParseHelper;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 11/02/2015.
 */
public class SearchCoursesAdapter extends BaseExpandableListAdapter {
    private final ArrayList<RowItemSearchCourses> grupos;
    public LayoutInflater inflater;
    public Activity activity;
    private List<ParseObject> courses;


    // Constructor
    public SearchCoursesAdapter(Activity act, ArrayList<RowItemSearchCourses> grupos, List<ParseObject> courses) {
        activity = act;
        this.grupos = grupos;
        this.courses = courses;
        inflater = act.getLayoutInflater();
    }


    // Nos devuelve los datos asociados a un subitem en base
    // a la posición
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return grupos.get(groupPosition).getChild();
    }


    // Devuelve el id de un item o subitem en base a la
    // posición de item y subitem
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }
    // En base a la posición del item y de subitem nos devuelve
    // el objeto view correspondiente y el layout para los subitems



    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //final String children = (String) getChild(groupPosition, childPosition);
        RowItemSearchCourses grupo = (RowItemSearchCourses) getGroup(groupPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.searchcourses_subitem, null);
        }
        TextView definition = (TextView)convertView.findViewById(R.id.course_definition);
        TextView num_chapters = (TextView)convertView.findViewById(R.id.course_numberChapters);
        Button btnLearn = (Button)convertView.findViewById(R.id.buttonLearn);
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // cogemos los punteros para la tabla
                ParseObject user = ParseUser.getCurrentUser();
                ParseObject course = courses.get(groupPosition);
                // cramos el parseHelper
                ParseHelper parseHelper = new ParseHelper();
                parseHelper.setNewMyCourse(user, course);
                // avisamos que el curso a sido guardado
                Toast.makeText(activity,"Apuntado", Toast.LENGTH_LONG).show();


                // guardar en base de datos local tambien
                DataSource dataSource = new DataSource(activity);
                ParseObject curso = courses.get(groupPosition);
                //dataSource.insertContactCursos(new BeanCursos(curso.getObjectId(), curso.getString("Definition"), curso.getString("Name"), curso.getInt(""), ));
            }
        });
        definition.setText(grupo.getChild().getDefinition());
        num_chapters.setText("Chapters : "+Integer.toString(grupo.getChild().getNum_temas()));
        return convertView;
    }




    // Nos devuelve la cantidad de subitems que tiene un ítem
    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }
    //Los datos de un ítem especificado por groupPosition
    @Override
    public Object getGroup(int groupPosition) {
        return grupos.get(groupPosition);
    }
    //La cantidad de ítem que tenemos definidos
    @Override
    public int getGroupCount() {
        return grupos.size();
    }
    //Método que se invoca al contraer un ítem
    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }
    //Método que se invoca al expandir un ítem
    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }
    //Devuelve el id de un ítem
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }
    //Obtenemos el layout para los ítems




    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.searchcourses_item, null);
        }
        RowItemSearchCourses grupo = (RowItemSearchCourses) getGroup(groupPosition);
        TextView text = (TextView)convertView.findViewById(R.id.course_name);
        ImageView image = (ImageView)convertView.findViewById(R.id.course_image);
        CheckedTextView check = (CheckedTextView)convertView.findViewById(R.id.course_check);

        text.setText(grupo.getTitle());
        image.setImageBitmap(new ImageHelper().getRoundedCornerBitmap(grupo.getImageId(), 0));
        check.setChecked(isExpanded);
        return convertView;
    }





    @Override
    public boolean hasStableIds() {
        return false;
    }
    //Nos informa si es seleccionable o no un ítem o subitem
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
