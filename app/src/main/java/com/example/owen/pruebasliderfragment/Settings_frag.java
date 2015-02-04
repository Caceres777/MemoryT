package com.example.owen.pruebasliderfragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;


public class Settings_frag extends Fragment {
    Switch switchSonido;
    Switch switchVibracion;
    Switch switchNotificaciones;
    Switch switchRecordatorios;
    Switch switchSonidoTactil;
    // SharedPreferences settings;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;




    public Settings_frag() {
// Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarConfiguracion();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings_frag, container, false);
        prefs= PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor=prefs.edit();


        switchSonido=(Switch) v.findViewById(R.id.switch1);
        switchVibracion=(Switch) v.findViewById(R.id.switch2);
        switchNotificaciones=(Switch) v.findViewById(R.id.switch3);
        switchRecordatorios=(Switch) v.findViewById(R.id.switch4);
        switchSonidoTactil=(Switch) v.findViewById(R.id.switch5);
        //cargarConfiguracion();

        switchSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Sonido", switchSonido.isChecked()).commit();
            }
        });
        switchVibracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Vibracion", switchVibracion.isChecked()).commit();
            }
        });
        switchNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Notificaciones", switchNotificaciones.isChecked()).commit();
            }
        });
        switchRecordatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Recordatorios", switchRecordatorios.isChecked()).commit();
            }
        });
        switchSonidoTactil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("SonidoTactil", switchSonidoTactil.isChecked()).commit();
            }
        });
        return v;
    }


    public void cargarConfiguracion(){
        switchSonido.setChecked(prefs.getBoolean("Sonido", true));
        switchVibracion.setChecked(prefs.getBoolean("Vibracion", true));
        switchNotificaciones.setChecked(prefs.getBoolean("Notificaciones", true));
        switchRecordatorios.setChecked(prefs.getBoolean("Recordatorios", true));
        switchSonidoTactil.setChecked(prefs.getBoolean("SonidoTactil", true));
    }


}
