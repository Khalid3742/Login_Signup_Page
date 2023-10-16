package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText et1,et2;
    Button bt1;
    TextView tv1;
    private FirebaseAuth mAuth;

    String dumy_user= "xcom@gamil.com";
    String dumy_password= "1221";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=findViewById(R.id.username);
        et2=findViewById(R.id.password);
        bt1=findViewById(R.id.login_bt);
        tv1=findViewById(R.id.Sign);
      mAuth = FirebaseAuth.getInstance();
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= et1.getText().toString().trim();
                String password= et2.getText().toString().trim();
                if (username.isEmpty()){
                    et1.setError("Reqiured");
                    return;
                }
                if (password.isBlank()){
                    et2.setError("Reqiured");
                    return;
                }
                if(!username.equals(dumy_user)){
                    
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
                    et1.setError("Invalid Email Adress");
                    return;
                }

            mAuth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent i=new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(i);

                            }else
                            {
                                Toast.makeText(LoginActivity.this, "Email and Password is Invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            }


        });

    }
}