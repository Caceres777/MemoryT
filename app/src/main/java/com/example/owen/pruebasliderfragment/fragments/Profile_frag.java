package com.example.owen.pruebasliderfragment.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.owen.pruebasliderfragment.ImageHelper;
import com.example.owen.pruebasliderfragment.R;
import com.example.owen.pruebasliderfragment.RowItemMenu;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.util.List;


public class Profile_frag extends Fragment {

    private String[] statsTitles;
    private Integer[] statsImages ={R.drawable.ic_action_user,R.drawable.ic_action_user,R.drawable.ic_action_user
            ,R.drawable.ic_action_user,R.drawable.ic_action_user,R.drawable.ic_action_user,R.drawable.ic_action_user,
            R.drawable.ic_action_user,R.drawable.ic_action_user,R.drawable.ic_action_user ,R.drawable.ic_action_user};
    private String[] statsAnswer = {"0","0","0","0","0","0","0","0","0","0","0"};
    List<RowItemMenu> rowItems;


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

        // creation of the players stats


        // creation of the edit profile button
        ImageView edit_button = (ImageView)v.findViewById(R.id.profile_edit);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // we call the edit profile fragment
            }
        });


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
