package com.example.owen.pruebasliderfragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class Login_frag extends Fragment {

    Button btnLogin;
    EditText user, pass;




    public Login_frag() {
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

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        user = (EditText)v.findViewById(R.id.user_email);
        pass = (EditText)v.findViewById(R.id.login_Pass);
        // Button login and listener
        btnLogin = (Button)v.findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        return v;
    }






    public void login(){
        ParseUser.logInInBackground(user.getText().toString(), pass.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    // Hooray! The user is logged in.
                    startActivity(new Intent(getActivity(), Memoryt_home.class));
                    getActivity().overridePendingTransition(R.animator.left_in, R.animator.left_out);
                } else {
                    Toast toastMensajeError= Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_LONG);
                    toastMensajeError.show();
                    // Signup failed.
                }
            }
        });
    }

}
