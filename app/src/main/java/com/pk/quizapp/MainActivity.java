package com.pk.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email, pwd;
    Button connect;
    TextView register;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.pass);
        connect = findViewById(R.id.btnAuth);
        register = findViewById(R.id.ToRegister);
        fauth = FirebaseAuth.getInstance();

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pass = pwd.getText().toString().trim();

                if (TextUtils.isEmpty(mail)) {
                    email.setError("please enter your E-Mail");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    pwd.setError("please enter your password");
                    return;
                }

                fauth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "Authentication succeeded ! ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), start_Activity.class));


                        } else {
                            Toast.makeText(MainActivity.this, "Erreur ! " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.pk.quizapp.registerActivity.class));


            }
        });
    }
}