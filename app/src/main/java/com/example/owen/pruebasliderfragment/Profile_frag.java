package com.example.owen.pruebasliderfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class Profile_frag extends Fragment {

    private String[] statsTitles;
    private Integer[] statsImages ={R.drawable.ic_action_home,R.drawable.ic_action_courses,R.drawable.ic_action_profile
            ,R.drawable.ic_action_vs,R.drawable.ic_action_search,R.drawable.ic_action_badge,R.drawable.ic_action_settings,
            R.drawable.ic_action_home,R.drawable.ic_action_courses,R.drawable.ic_action_profile ,R.drawable.ic_action_vs};
    private String[] statsAnswer = {"0","0","0","0","0","0","0","0","0","0","0"};
    List<RowItem> rowItems;


    public Profile_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_frag, container, false);

        // craetion of the top bar with the users stats
        ImageView profile_img = (ImageView)v.findViewById(R.id.profile_pic);
        setProfileImg(profile_img);

        TextView user_name = (TextView)v.findViewById(R.id.profile_name);
        user_name.setText(ParseUser.getCurrentUser().getUsername());

        TextView user_level = (TextView)v.findViewById(R.id.profile_level);
        user_level.setText(user_level.getText()+Integer.toString(ParseUser.getCurrentUser().getInt("level")));

        ProgressBar level = (ProgressBar)v.findViewById(R.id.profile_progressBar);
        level.setProgress(ParseUser.getCurrentUser().getInt("exp"));

        // creation of the list view and its items
        ListView stats = (ListView) v.findViewById(R.id.listView_stats);
        statsTitles = getResources().getStringArray(R.array.Memoryt_profile_stats);
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < statsTitles.length; i++) {
            RowItem item = new RowItem(statsImages[i], statsTitles[i], statsAnswer[i]);
            rowItems.add(item);
        }
        StatsAdapter adapter = new StatsAdapter(stats.getContext(), R.layout.stats_item, rowItems);
        stats.setAdapter(adapter);
        return v;
    }


    public void setProfileImg(ImageView imageview){
        ParseFile data = (ParseFile) ParseUser.getCurrentUser().get("image");
        if(data != null) {
            try {
                byte[] img = data.getData();
                Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                bitmap = Bitmap.createScaledBitmap(bitmap, 180, 180, true);
                imageview.setImageBitmap(new ImageHelper().getRoundedCornerBitmap(bitmap,90));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
