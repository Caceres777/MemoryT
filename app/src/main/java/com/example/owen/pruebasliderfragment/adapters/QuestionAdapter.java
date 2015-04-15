package com.example.owen.pruebasliderfragment.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.ListViewItems.RowItemQuestion;
import com.example.owen.pruebasliderfragment.R;

import java.util.List;

/**
 * Created by Owen on 18/03/2015.
 */
public class QuestionAdapter extends ArrayAdapter<RowItemQuestion> {

    Context context;
    TextView pregunta, fallos, aciertos;
    List<RowItemQuestion> items;


    public QuestionAdapter(Context context, int resource, List<RowItemQuestion> items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowItemQuestion rowItemMenu = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.question_item, null);
        pregunta = (TextView) convertView.findViewById(R.id.pregunta);
        fallos = (TextView) convertView.findViewById(R.id.fallos);
        aciertos = (TextView) convertView.findViewById(R.id.aciertos);

        pregunta.setText(rowItemMenu.getPregunta()+" ("+rowItemMenu.getRespuesta()+")");
        fallos.setText(Integer.toString(rowItemMenu.getFallos()));
        aciertos.setText(Integer.toString(rowItemMenu.getAciertos()));
        return convertView;
    }
}
