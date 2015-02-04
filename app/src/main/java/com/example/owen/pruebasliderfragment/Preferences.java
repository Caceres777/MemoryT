package com.example.owen.pruebasliderfragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;
/**
 * Created by CHUFASCHIN on 03/02/2015.
 */
public class Preferences extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.id.fragment_start);
    }

    public void mostrarPreferencias(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String s = "música: "+ pref.getBoolean("musica",true)+", gráficos: " + pref.getString("graficos","?");
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }
}
