package com.ervincs.finalprojectlnt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CounterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CounterFragment extends Fragment {
    Button substract, add, reset;
    TextView countView;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    int count;

    public void update(){
        editor.putInt("count",count).apply();
        countView.setText(""+sharedPref.getInt("count",0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_counter, container, false);
        sharedPref = this.getActivity().getSharedPreferences("counterValue", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        countView = (TextView)view.findViewById(R.id.counter);
        countView.setText(""+(sharedPref.getInt("count",0)));
        count = sharedPref.getInt("count",0);
        substract = (Button)view.findViewById(R.id.min);
        reset = (Button)view.findViewById(R.id.reset);
        add = (Button)view.findViewById(R.id.plus);
        substract.setOnClickListener(v -> {
            count--;
            update();
        });
        add.setOnClickListener(v -> {
            count++;
            update();
        });
        reset.setOnClickListener(v -> {
            count = 0;
            update();
        });
        return view;
    }
}