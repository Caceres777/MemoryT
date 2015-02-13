package com.example.owen.pruebasliderfragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;


public class ListExpandableSearchCourses extends Activity {
    SparseArray<GrupoDeItemsSearchCourses> grupos = new SparseArray<GrupoDeItemsSearchCourses>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearCursos();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listViewexp);
        SearchCoursesAdapter adapter = new SearchCoursesAdapter(this, grupos);
        listView.setAdapter(adapter);
    }
    public void crearCursos() {
        int numeroCursos= 5;
        for(int i=0; i<=numeroCursos;i++){
            GrupoDeItemsSearchCourses grupo0 = new GrupoDeItemsSearchCourses("Curso "+i);
            grupo0.children.add("Explicacion");
            grupo0.children.add("Progreso del cursos (+seguir/continuar)");
            grupos.append(i, grupo0);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
