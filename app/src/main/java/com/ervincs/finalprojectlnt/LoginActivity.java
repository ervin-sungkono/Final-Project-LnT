package com.ervincs.finalprojectlnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    Bundle bundle;
    EditText email, password;
    TextView regText;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent gotoRegister = new Intent(LoginActivity.this,MainActivity.class);
        Intent gotoHome = new Intent(LoginActivity.this, HomeActivity.class);
        sharedPref = getSharedPreferences("userData", MODE_PRIVATE);
        bundle = new Bundle();
        bundle.putString("name",sharedPref.getString("name",""));
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPass);
        regText = findViewById(R.id.regLink);
        login = findViewById(R.id.loginbtn);
        regText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoRegister);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sharedPref.getString("email","").equals(email.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Email does not exist", Toast.LENGTH_SHORT).show();
                }
                else if(!sharedPref.getString("password","").equals(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Password incorrect", Toast.LENGTH_SHORT).show();
                }
                else {
                    gotoHome.putExtras(bundle);
                    startActivity(gotoHome);
                }
            }
        });
    }
}