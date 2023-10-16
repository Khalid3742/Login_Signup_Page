package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
     EditText et1,et2,et3;
     Button bt1;
     TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et1=findViewById(R.id.username);
        et2=findViewById(R.id.email);
        et3=findViewById(R.id.password);
        bt1=findViewById(R.id.sign_bt);
        tv1=findViewById(R.id.Sign);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et1.getText().toString().trim();
                String email = et2.getText().toString().trim();
                String password = et3.getText().toString().trim();
                if (username.isEmpty()) {
                    et1.setError("Reqiured");
                    return;
                }
                if (email.isEmpty()) {
                    et2.setError("Reqiured");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                    et1.setError("Invalid Email Adress");
                    return;
                }
                    if (password.isEmpty()) {
                        et3.setError("Reqiured");
                        return;
                    }

                    Toast.makeText(SignupActivity.this, "All Oky", Toast.LENGTH_SHORT).show();

            }///
        });
    }
}