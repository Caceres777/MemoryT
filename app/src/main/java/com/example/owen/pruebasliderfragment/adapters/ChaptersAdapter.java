package com.example.owen.pruebasliderfragment.adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.JavaBean.BeanChapter;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemChapter;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.fragments.Questions_frag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 11/02/2015.
 */
public class ChaptersAdapter extends BaseExpandableListAdapter {

    private final ArrayList<RowItemChapter> grupos;
    private List<BeanChapter> temas;
    public LayoutInflater inflater;
    public Activity activity;
    private FragmentManager fm;
    private FragmentTransaction ft;


    // Constructor
    public ChaptersAdapter(Activity act, ArrayList<RowItemChapter> grupos, List<BeanChapter> temas) {
        activity = act;
        this.grupos = grupos;
        inflater = act.getLayoutInflater();
        this.temas = temas;
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
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        RowItemChapter grupo = (RowItemChapter) getGroup(groupPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.chapter_subitem, null);
        }
        TextView num_word = (TextView) convertView.findViewById(R.id.chapter_num_words);
        TextView num_word_learn = (TextView) convertView.findViewById(R.id.chapter_num_words_learn);
        TextView accuracy = (TextView) convertView.findViewById(R.id.chapter_accuracy);

        num_word.setText(Integer.toString(grupo.getChild().getNum_palabras()));
        num_word_learn.setText(Integer.toString(grupo.getChild().getNum_palabras_aprendidas()));
        accuracy.setText(Integer.toString(grupo.getChild().getAccuracy()) + " %");
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
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.chapter_item, null);
        }
        RowItemChapter grupo = (RowItemChapter) getGroup(groupPosition);
        TextView text = (TextView)convertView.findViewById(R.id.chapter_name);
        ProgressBar progress = (ProgressBar) convertView.findViewById(R.id.chapter_progressBar);
        CheckedTextView check = (CheckedTextView)convertView.findViewById(R.id.course_check);
        Button btnStart = (Button) convertView.findViewById(R.id.start_button);
        btnStart.setFocusable(false);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call new fragment Introducir un thread de carga
                fm = activity.getFragmentManager();
                ft = fm.beginTransaction();
                ft.setCustomAnimations(R.animator.slide_in_left_frag, R.animator.slide_out_right_frag);
                Questions_frag questions = new Questions_frag();
                questions.setTema(temas.get(groupPosition));
                ft.replace(R.id.container, questions);
                ft.commit();
            }
        });

        if(grupo.getProgress()==0){
            btnStart.setText("Start");
        }else {
            if (grupo.getProgress() > 0 && grupo.getProgress() < 100)
                btnStart.setText("Continue");
            else {
                btnStart.setText("Review");
                //btnStart.setBackgroundColor(convertView.getResources(R.color.Dark_orange));
            }
        }
        text.setText(groupPosition+" "+grupo.getTitle());
        progress.setProgress(grupo.getProgress());
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
