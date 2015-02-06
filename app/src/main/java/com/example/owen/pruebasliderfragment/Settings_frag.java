package com.example.owen.pruebasliderfragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
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
        cargarConfiguracion();

        switchSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valor = switchSonido.isChecked();
                editor.putBoolean("Sonido", valor).apply();
            }
        });
        switchVibracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valor = switchVibracion.isChecked();
                editor.putBoolean("Vibracion", switchVibracion.isChecked()).apply();
            }
        });
        switchNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valor = switchNotificaciones.isChecked();
                editor.putBoolean("Notificaciones", switchNotificaciones.isChecked()).apply();
            }
        });
        switchRecordatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valor = switchRecordatorios.isChecked();
                editor.putBoolean("Recordatorios", switchRecordatorios.isChecked()).apply();
            }
        });
        switchSonidoTactil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valor = switchSonidoTactil.isChecked();
                editor.putBoolean("SonidoTactil", switchSonidoTactil.isChecked()).apply();
            }
        });
        return v;
    }


    public void cargarConfiguracion(){
        String valor = Boolean.toString(prefs.getBoolean("Sonido", true));
        Log.d("Sonido", valor);
        valor = Boolean.toString(prefs.getBoolean("Vibracion", true));
        Log.d("Vibracion", valor);
        valor = Boolean.toString(prefs.getBoolean("Notificaciones", true));
        Log.d("Notificaciones", valor);
        valor = Boolean.toString(prefs.getBoolean("Recordatorios", true));
        Log.d("Recordatorios", valor);
        valor = Boolean.toString(prefs.getBoolean("SonidoTactil", true));
        Log.d("SonidoTactil", valor);
        switchSonido.setChecked(prefs.getBoolean("Sonido", true));
        switchVibracion.setChecked(prefs.getBoolean("Vibracion", true));
        switchNotificaciones.setChecked(prefs.getBoolean("Notificaciones", true));
        switchRecordatorios.setChecked(prefs.getBoolean("Recordatorios", true));
        switchSonidoTactil.setChecked(prefs.getBoolean("SonidoTactil", true));
    }


}
