package com.example.owen.pruebasliderfragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.io.ByteArrayOutputStream;


public class Register_frag extends Fragment {

    Button btnRegister;
    EditText email = null, pass1, pass2, user;
    ParseUser newUser;
    ParseFile parseImage;
    byte[] image;
    static String mensajeContrasenaMala = "contrasena incorrecta";
    static String mensajeCamposVacios = "Faltan campos por rellenar";
    static String mensajeNoReg = "No se a podido registrar";
    static String mensajeReg = "Registro con exito";
    Toast toastCamposVacios, toastMensajeError, toastMensajeCorreto, toastContr;
    private static final String TAG="activity_register";





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

        // definition of the text fields
        user = (EditText)v.findViewById(R.id.register_user);
        email = (EditText) v.findViewById(R.id.register_email);
        pass1 = (EditText) v.findViewById(R.id.register_Pass1);
        pass2 = (EditText) v.findViewById(R.id.register_Pass2);
        // mensajes de error
        toastContr = Toast.makeText(getActivity(), mensajeContrasenaMala, Toast.LENGTH_LONG);
        toastCamposVacios= Toast.makeText(getActivity(), mensajeCamposVacios, Toast.LENGTH_LONG);
        toastMensajeError= Toast.makeText(getActivity(), mensajeNoReg, Toast.LENGTH_LONG);
        toastMensajeCorreto=Toast.makeText(getActivity(),mensajeReg, Toast.LENGTH_LONG);

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







    // method in charge of the users register
    public void register(){
        String user_name=user.getText().toString();
        String user_email=email.getText().toString();
        String password1=pass1.getText().toString();
        String password2=pass2.getText().toString();
        if("".equals(user_email) ||"".equals(password1) || "".equals(password2)){
            toastCamposVacios.show();
        }else{
            if(!password1.equals(password2)){
                toastContr.show();
            }else{
                newUser= new ParseUser();
                newUser.setUsername(user_name);
                newUser.setEmail(user_email);
                newUser.setPassword(password1);
                Bitmap profile_img = BitmapFactory.decodeResource(getResources(), R.drawable.user_img);
                // Convert it to byte
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                // Compress image to lower quality scale 1 - 100
                profile_img.compress(Bitmap.CompressFormat.PNG, 100, stream);
                image = stream.toByteArray();
                parseImage = new ParseFile("profilePic.png", image);
                parseImage.saveInBackground(new SaveCallback() {
                    public void done(ParseException e) {
                        // If successful add file to user and signUpInBackground
                        newUser.put("image", parseImage);
                        newUser.signUpInBackground(new SignUpCallback() {
                            public void done(ParseException e) {
                                if (e == null) {
                                    // sing up was successful
                                    toastMensajeCorreto.show();
                                    startActivity(new Intent(getActivity(), Home.class));
                                    getActivity().overridePendingTransition(R.animator.left_in, R.animator.left_out);
                                } else {
                                    // sing in wasn't successful, show a Log with reason
                                    toastMensajeError= Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_LONG);
                                    toastMensajeError.show();
                                }
                            }
                        });
                    }
                });
            }
        }
    }

}
