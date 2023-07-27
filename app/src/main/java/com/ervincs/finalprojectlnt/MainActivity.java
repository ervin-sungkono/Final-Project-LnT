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

public class MainActivity extends AppCompatActivity {
    TextView loginText;
    EditText id, email, name, pass, confpass;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = getSharedPreferences("userData", MODE_PRIVATE);
        editor = sharedPref.edit();
        Intent goLoginPage = new Intent(MainActivity.this, LoginActivity.class);
        loginText = findViewById(R.id.loginLink);
        id = findViewById(R.id.etID);
        email = findViewById(R.id.etEmail);
        name = findViewById(R.id.etName);
        pass = findViewById(R.id.etPass);
        confpass = findViewById(R.id.etConf);
        register = findViewById(R.id.regbtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().length() <= 0){
                    Toast.makeText(MainActivity.this, "ID cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().indexOf('@') == -1 || !email.getText().toString().endsWith(".com")){
                    Toast.makeText(MainActivity.this, "Email must contain '@' and ends with .com", Toast.LENGTH_SHORT).show();
                }
                else if(name.getText().toString().length() < 5){
                    Toast.makeText(MainActivity.this, "Name is must be atleast 5 letters long", Toast.LENGTH_SHORT).show();
                }
                else if(pass.getText().toString().length()<=0){
                    Toast.makeText(MainActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(!pass.getText().toString().equals(confpass.getText().toString())){
                    Toast.makeText(MainActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    editor.putString("id_bimble",id.getText().toString());
                    editor.putString("email",email.getText().toString());
                    editor.putString("name",name.getText().toString());
                    editor.putString("password",pass.getText().toString());
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Account has been created!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goLoginPage);
            }
        });
    }
}