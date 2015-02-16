package com.example.owen.pruebasliderfragment.adapters;

/**
 * Created by Owen on 12/02/2015.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.ListViewItems.RowItemsBadges;

import java.util.ArrayList;

/**
 * Created by Carlos on 11/02/2015.
 */
public class BadgesAdapter extends BaseExpandableListAdapter {

    private final ArrayList<RowItemsBadges> grupos;
    public LayoutInflater inflater;
    public Activity activity;


    // Constructor
    public BadgesAdapter(Activity act, ArrayList<RowItemsBadges> grupos) {
        activity = act;
        this.grupos = grupos;
        inflater = act.getLayoutInflater();
    }


    // Nos devuelve los datos asociados a un subitem en base
    // a la posición
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return grupos.get(groupPosition).children.get(childPosition);
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.badge_subitem, null);
        }
        RowItemsBadges grupo = (RowItemsBadges) getGroup(groupPosition);
        TextView text = (TextView) convertView.findViewById(R.id.badge_text);
        TextView title = (TextView) convertView.findViewById(R.id.badge_title);
        ImageView image = (ImageView) convertView.findViewById(R.id.badge_image);
        text.setText(grupo.children.get(childPosition).getBadgeText());
        image.setImageResource(grupo.children.get(childPosition).getBadgeImage());
        title.setText(grupo.children.get(childPosition).getBadgeTitle());
        return convertView;
    }


    // Nos devuelve la cantidad de subitems que tiene un ítem
    @Override
    public int getChildrenCount(int groupPosition) {
        return grupos.get(groupPosition).children.size();
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
            convertView = inflater.inflate(R.layout.badge_item, null);
        }
        RowItemsBadges grupo = (RowItemsBadges) getGroup(groupPosition);
        ImageView image = (ImageView)convertView.findViewById(R.id.course_image);
        TextView text = (TextView)convertView.findViewById(R.id.course_name);
        CheckedTextView check = (CheckedTextView)convertView.findViewById(R.id.course_check);
        image.setImageResource(grupo.title_img);
        text.setText(grupo.title);
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

