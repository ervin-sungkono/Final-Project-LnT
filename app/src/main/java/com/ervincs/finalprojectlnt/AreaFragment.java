package com.ervincs.finalprojectlnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class AreaFragment extends Fragment {
    EditText panjang,lebar,alas,tinggi,ruas;
    TextView hasilPersegi, hasilSegitiga, hasilLingkaran;
    Button hitung1,hitung2,hitung3;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_area, container, false);

        panjang = view.findViewById(R.id.etPanjang);
        lebar = view.findViewById(R.id.etLebar);
        alas = view.findViewById(R.id.etAlas);
        tinggi = view.findViewById(R.id.etTinggi);
        ruas = view.findViewById(R.id.etRuas);
        hasilPersegi = view.findViewById(R.id.resultPersegi);
        hasilSegitiga = view.findViewById(R.id.resultSegitiga);
        hasilLingkaran = view.findViewById(R.id.resultLingkaran);
        hitung1 = view.findViewById(R.id.hitungPersegi);
        hitung2 = view.findViewById(R.id.hitungSegitiga);
        hitung3 = view.findViewById(R.id.hitungLingkaran);

        hitung1.setOnClickListener(
                v -> {
                    if(panjang.getText().toString().length()<=0 || lebar.getText().toString().length() <=0){
                        return;
                    }
                    Double p,l,luasPersegi;
                    p = Double.parseDouble(panjang.getText().toString());
                    l = Double.parseDouble(lebar.getText().toString());
                    luasPersegi = p*l;

                    hasilPersegi.setText("Result: "+ df.format(luasPersegi));
        });

        hitung2.setOnClickListener((
                v -> {
                    if(alas.getText().toString().length()<=0 || tinggi.getText().toString().length() <=0){
                        return;
                    }
                    Double a,t,luasSegitiga;
                    a = Double.parseDouble(alas.getText().toString());
                    t = Double.parseDouble(tinggi.getText().toString());
                    luasSegitiga = a*t/2;

                    hasilSegitiga.setText("Result: "+df.format(luasSegitiga));

        }));

        hitung3.setOnClickListener(
                v -> {
                    if(ruas.getText().toString().length()<=0){
                        return;
                    }
                    Double r,luasLingkaran;
                    r = Double.parseDouble(ruas.getText().toString());
                    luasLingkaran = (22.0/7)*r*r;

                    hasilLingkaran.setText("Result: "+df.format(luasLingkaran));
        });
        return view;
    }
}