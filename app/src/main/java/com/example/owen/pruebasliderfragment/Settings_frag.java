package com.example.owen.pruebasliderfragment;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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
//    SharedPreferences settings;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public Settings_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs= getActivity().getSharedPreferences("MemorytPrefs", Context.MODE_PRIVATE);
        editor=prefs.edit();
        switchSonido=(Switch) getActivity().findViewById(R.id.switch1);
        switchVibracion=(Switch) getActivity().findViewById(R.id.switch2);
        switchNotificaciones=(Switch) getActivity().findViewById(R.id.switch3);
        switchRecordatorios=(Switch) getActivity().findViewById(R.id.switch4);
        switchSonidoTactil=(Switch) getActivity().findViewById(R.id.switch5);
        cargarConfiguracion();

        switchSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Sonido", switchSonido.isChecked());
            }
        });
        switchVibracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Vibracion", switchVibracion.isChecked());
            }
        });
        switchNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Notificaciones", switchNotificaciones.isChecked());
            }
        });
        switchRecordatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("Recordatorios", switchRecordatorios.isChecked());
            }
        });
        switchSonidoTactil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("SonidoTactil", switchSonidoTactil.isChecked());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings_frag, container, false);
    }

    public void guardarConfiguracion()
    {
        editor.putBoolean("Sonido", switchSonido.isChecked());
        editor.putBoolean("Vibracion", switchVibracion.isChecked());
        editor.putBoolean("Notificaciones", switchNotificaciones.isChecked());
        editor.putBoolean("Recordatorios", switchRecordatorios.isChecked());
        editor.putBoolean("SonidoTactil", switchSonidoTactil.isChecked());
        editor.commit();
    }
    public void cargarConfiguracion(){
        SharedPreferences prefs =getActivity().getSharedPreferences("MemorytPrefs", Context.MODE_PRIVATE);
        switchSonido.setChecked(prefs.getBoolean("Sonido", true));
        switchVibracion.setChecked(prefs.getBoolean("Vibracion", true));
        switchNotificaciones.setChecked(prefs.getBoolean("Notificaciones", true));
        switchRecordatorios.setChecked(prefs.getBoolean("Recordatorios", true));
        switchSonidoTactil.setChecked(prefs.getBoolean("SonidoTactil", true));
    }

}
