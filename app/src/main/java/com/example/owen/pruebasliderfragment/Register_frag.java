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

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class Register_frag extends Fragment {

    Button btnRegister;
    EditText email = null;
    EditText contrasena;
    EditText contrasena2;
    static String mensajeContrasenaMala = "contrasena incorrecta";
    static String mensajeCamposVacios = "Faltan campos por rellenar";
    static String mensajeC = "EXITO GARRAFAL, NICO PAGAFANTAS!!";
    Toast toastContr;
    Toast toastCamposVacios;
    Toast mensaje;
    Log log;
    Button register;

    public Register_frag() {
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
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        email = (EditText) v.findViewById(R.id.editEmail);
        contrasena = (EditText) v.findViewById(R.id.editPass1);
        contrasena2 = (EditText) v.findViewById(R.id.editPass2);
        register= (Button) v.findViewById(R.id.buttonRegister);
        toastContr = Toast.makeText(getActivity(), mensajeContrasenaMala, Toast.LENGTH_LONG);
        toastCamposVacios= Toast.makeText(getActivity(), mensajeCamposVacios, Toast.LENGTH_LONG);
        mensaje= Toast.makeText(getActivity(), mensajeC, Toast.LENGTH_LONG);

        // Button register and listener
        btnRegister = (Button)v.findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        return v;
    }

    public void register(){
        String usuario=email.getText().toString();
        String contrasenia=contrasena.getText().toString();
        String contrasenia2=contrasena2.getText().toString();
        // Log.d(TAG, "USUARIO="+email.getText().toString()+"CONTRASENIA="+contrasena.getText().toString()+"CONTRASENIA2="+contrasena2.getText().toString());
        if("".equals(usuario) ||"".equals(contrasenia) || "".equals(contrasenia2)){
            toastCamposVacios.show();
                // Log.d(TAG, "USUARIO="+email.getText().toString()+"CONTRASENIA="+contrasena.getText().toString()+"CONTRASENIA2="+contrasena2.getText().toString());
                // Log.d(TAG, "campos VACIOS");
        }
        else{
            if(!contrasenia.equals(contrasenia2)){
                toastContr.show();
                // Log.d(TAG, "USUARIO="+email.getText()+"CONTRASENIA="+contrasena.getText()+"CONTRASENIA2="+contrasena2.getText());
                // Log.d(TAG, "contrasenias INCORRECTAS");
            }
            else{
                mensaje.show();
                //Log.d(TAG, "BIEEN");
                ParseObject newUser= new ParseObject("User");
                newUser.put("user",usuario);
                newUser.put("password",contrasenia);
                newUser.saveInBackground();
                startActivity(new Intent(getActivity(), Home.class));
            }
        }
    }

}
