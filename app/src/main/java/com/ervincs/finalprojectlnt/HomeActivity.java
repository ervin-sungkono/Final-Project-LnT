package com.ervincs.finalprojectlnt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(itemSelectedListener);
        nameView = findViewById(R.id.nameView);
        Intent prevIntent = getIntent();
        Bundle bundle = prevIntent.getExtras();

        nameView.setText(bundle.getString("name"));

        getSupportFragmentManager().beginTransaction().replace(R.id.layout_frame, new CounterFragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener =
            item -> {
                Fragment fragment = null;
                if(item.getItemId() == R.id.counter){
                    fragment = new CounterFragment();
                }
                else if(item.getItemId() == R.id.area){
                    fragment = new AreaFragment();
                }
                else if(item.getItemId() == R.id.volume){
                    fragment = new VolumeFragment();
                }               getSupportFragmentManager().beginTransaction().replace(R.id.layout_frame, fragment).commit();

                return true;
            };
}