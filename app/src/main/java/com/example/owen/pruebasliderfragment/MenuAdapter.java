package com.example.owen.pruebasliderfragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Owen on 01/02/2015.
 */
public class MenuAdapter  extends ArrayAdapter<RowItem> {

    Context context;

    public MenuAdapter(Context context, int resourceId, List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }


    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.menu_item, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.name);
            holder.imageView = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtTitle.setText(rowItem.getTitle());
        holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }
}
