package com.ervincs.finalprojectlnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class VolumeFragment extends Fragment {
    EditText panjangBalok,lebarBalok,tinggiBalok,panjangPiramid,lebarPiramid,tinggiPiramid,ruasTabung,tinggiTabung;
    TextView hasilBalok,hasilPiramid,hasilTabung;
    Button hitung1,hitung2,hitung3;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_volume, container, false);

        panjangBalok = view.findViewById(R.id.etPanjang1);
        lebarBalok = view.findViewById(R.id.etLebar1);
        tinggiBalok = view.findViewById(R.id.etTinggi1);
        panjangPiramid = view.findViewById(R.id.etPanjang2);
        lebarPiramid = view.findViewById(R.id.etLebar2);
        tinggiPiramid = view.findViewById(R.id.etTinggi2);
        ruasTabung = view.findViewById(R.id.etRuas);
        tinggiTabung = view.findViewById(R.id.etTinggi3);
        hasilBalok = view.findViewById(R.id.hasilBalok);
        hasilPiramid = view.findViewById(R.id.hasilPiramid);
        hasilTabung = view.findViewById(R.id.hasilTabung);
        hitung1 = view.findViewById(R.id.hitungBalok);
        hitung2 = view.findViewById(R.id.hitungPiramid);
        hitung3 = view.findViewById(R.id.hitungTabung);

        hitung1.setOnClickListener(
                v -> {
                    if(panjangBalok.getText().toString().length()<=0 || lebarBalok.getText().toString().length() <=0 || tinggiBalok.getText().toString().length()<=0)
                        return;
                    Double p,l,t,volumeBalok;
                    p = Double.parseDouble(panjangBalok.getText().toString());
                    l = Double.parseDouble(lebarBalok.getText().toString());
                    t = Double.parseDouble(tinggiBalok.getText().toString());

                    volumeBalok = p*l*t;
                    hasilBalok.setText("Result: "+ df.format(volumeBalok));
        });

        hitung2.setOnClickListener(
                v -> {
                    if(panjangPiramid.getText().toString().length()<=0 || lebarPiramid.getText().toString().length() <=0 || tinggiPiramid.getText().toString().length()<=0)
                        return;
                    Double p,l,t,volumePiramid;
                    p = Double.parseDouble(panjangPiramid.getText().toString());
                    l = Double.parseDouble(lebarPiramid.getText().toString());
                    t = Double.parseDouble(tinggiPiramid.getText().toString());

                    volumePiramid = p*l*t/3.0;
                    hasilPiramid.setText("Result: "+ df.format(volumePiramid));
        });

        hitung3.setOnClickListener(
                v -> {
                    if(ruasTabung.getText().toString().length()<=0 || tinggiTabung.getText().toString().length() <=0)
                        return;
                    Double r,t,volumeTabung;
                    r = Double.parseDouble(ruasTabung.getText().toString());
                    t = Double.parseDouble(tinggiTabung.getText().toString());

                    volumeTabung = (22.0/7)*r*r*t;
                    hasilTabung.setText("Result: " + df.format(volumeTabung));
        });
        return view;
    }
}