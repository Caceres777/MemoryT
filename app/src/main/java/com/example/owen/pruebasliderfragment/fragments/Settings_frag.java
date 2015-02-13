package com.example.owen.pruebasliderfragment.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.owen.pruebasliderfragment.R;


public class Settings_frag extends Fragment {

    String[] ajustes;
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


        ajustes = getResources().getStringArray(R.array.Memoryt_settings);
        switchSonido=(Switch) v.findViewById(R.id.switch1);
        switchVibracion=(Switch) v.findViewById(R.id.switch2);
        switchNotificaciones=(Switch) v.findViewById(R.id.switch3);
        switchRecordatorios=(Switch) v.findViewById(R.id.switch4);
        switchSonidoTactil=(Switch) v.findViewById(R.id.switch5);


        switchSonido.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(ajustes[0], buttonView.isChecked()).apply();
            }
        });

        switchVibracion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(ajustes[1], buttonView.isChecked()).apply();
            }
        });

        switchNotificaciones.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(ajustes[2], buttonView.isChecked()).apply();
            }
        });

        switchRecordatorios.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(ajustes[3], buttonView.isChecked()).apply();
            }
        });

        switchSonidoTactil.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean(ajustes[4], buttonView.isChecked()).apply();
            }
        });

        return v;
    }


    public void cargarConfiguracion(){
        switchSonido.setChecked(prefs.getBoolean(ajustes[0], true));
        switchVibracion.setChecked(prefs.getBoolean(ajustes[1], true));
        switchNotificaciones.setChecked(prefs.getBoolean(ajustes[2], true));
        switchRecordatorios.setChecked(prefs.getBoolean(ajustes[3], true));
        switchSonidoTactil.setChecked(prefs.getBoolean(ajustes[4], true));
    }


}
