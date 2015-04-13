package com.example.owen.pruebasliderfragment.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.activities.Game;

import java.util.List;


/**
 * Created by Owen on 18/03/2015.
 */
public class GameAnswerAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> items;
    Button respuesta;
    int correcto;

    public GameAnswerAdapter(Context context, int resource, List<String> items, int correcto) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
        this.correcto = correcto;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String answer = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.answer_item, null);
        respuesta = (Button) convertView.findViewById(R.id.gameAsnwer);
        respuesta.setFocusable(false);
        respuesta.setFocusableInTouchMode(false);
        respuesta.setText(answer);
        respuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // comprobar si es correcta
                Button boton = (Button)v.findViewById(R.id.gameAsnwer);
                boolean right = false;
                if(position==correcto){
                    boton.setBackgroundColor(context.getResources().getColor(R.color.Green));
                    right = true;
                }else
                    boton.setBackgroundColor(context.getResources().getColor(R.color.Red));
                // llamar a nueva pregunta
                ((Game)context).setCorrectOrWrong(right);
                ((Game)context).setNewQuestion();
            }
        });
        return convertView;
    }
}
