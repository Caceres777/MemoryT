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


    Button btnReg, btnLogin;
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
        return v;


    }

}
