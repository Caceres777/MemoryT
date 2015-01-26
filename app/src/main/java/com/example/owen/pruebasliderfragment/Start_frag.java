package com.example.owen.pruebasliderfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Start_frag extends Fragment {


    Button btnReg, btnLogin, btnGoogle, btnFacebook;
    FragmentManager fragmentmanager;
    FragmentTransaction ft;

    public Start_frag() {
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
        View v = inflater.inflate(R.layout.fragment_start, container, false);

        fragmentmanager = getFragmentManager();
        ft = fragmentmanager.beginTransaction();

        // register button and listener
        btnReg = (Button)v.findViewById(R.id.buttonEMail);
        btnReg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register_frag registerFrag = new Register_frag();
                ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right,R.animator.slide_in_left, R.animator.slide_out_right);
                ft.replace(R.id.background_start, registerFrag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        // login button and listener
        btnLogin = (Button)v.findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_frag loginFrag = new Login_frag();
                ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right,R.animator.slide_in_left, R.animator.slide_out_right);
                ft.replace(R.id.background_start, loginFrag);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        // google plus button and listener
        btnGoogle = (Button)v.findViewById(R.id.buttonGooglePlus);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // facebook button and listener
        btnFacebook = (Button)v.findViewById(R.id.buttonFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;


    }

}
