package com.example.owen.pruebasliderfragment.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.owen.pruebasliderfragment.GrupoDeItemsSearchCourses;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.SearchCoursesAdapter;

public class SearchCourses_frag extends Fragment{
    SparseArray<GrupoDeItemsSearchCourses> grupos = new SparseArray<GrupoDeItemsSearchCourses>();
    String TAG=SearchCourses_frag.class.getSimpleName();
    public SearchCourses_frag() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {  super.onCreate(savedInstanceState);   }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_courses, container, false);
        ExpandableListView listView = (ExpandableListView) v.findViewById(R.id.listaBuscarCurso);
//        Button pr=(Button) v.findViewById(R.id.button);
//        Log.e(TAG, "error");
        crearCursos();
//        buscarCursos();
        SearchCoursesAdapter adapter = new SearchCoursesAdapter(getActivity(), grupos);
        listView.setAdapter(adapter);
        return v;
    }
    public void crearCursos() {
        int numeroCursos= 5;
        for(int i=0; i<=numeroCursos;i++){
            GrupoDeItemsSearchCourses grupo0 = new GrupoDeItemsSearchCourses("Curso "+i);
            grupo0.children.add("Explicación");
            grupo0.children.add("Progreso del cursos (+seguir/continuar)");
            grupos.append(i, grupo0);
        }
    }

//    public ArrayList<String> buscarCursos(){
////    String nombreCurso;
//    DataSource dataSource = null;
//    SQLiteDatabase db = dataSource.openReadable();
//    db.beginTransaction();
////    String cursos=(String)ContactBean.CursosEntry.;
//    String pruebaQuery="SELECT * FROM" + ContactBean.CursosEntry.getTableName();
////    Cursor cursor=db.query(Contact.CursosEntry.TABLE_NAME, new String[]{ContactBean.CursosEntry.getColumnIdCurso(),ContactBean.CursosEntry.getColumnNombre()}, null, new String[]{nombreCurso};
//    ArrayList<String> arrayCursos = null;
//    return arrayCursos;
//    }
}
