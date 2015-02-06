package com.example.owen.pruebasliderfragment;

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

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;


public class Profile_frag extends Fragment {


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

        ImageView profile_img = (ImageView)v.findViewById(R.id.profile_pic);
        setProfileImg(profile_img);

        TextView user_name = (TextView)v.findViewById(R.id.profile_name);
        user_name.setText(ParseUser.getCurrentUser().getUsername());

        ProgressBar level = (ProgressBar)v.findViewById(R.id.profile_progressBar);
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
