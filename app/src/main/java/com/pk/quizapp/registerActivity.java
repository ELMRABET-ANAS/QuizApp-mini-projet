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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registerActivity extends AppCompatActivity {

    EditText email,pwd,tele,nom,dateN,Ntele;
    Button register;
    FirebaseAuth fauth;
    FirebaseFirestore fStore;
    String usrID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.mail);
        pwd=findViewById(R.id.pwd);
        register=findViewById(R.id.register);
        nom = findViewById(R.id.name);
        dateN= findViewById(R.id.date);
        Ntele = findViewById(R.id.ph);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mail = email.getText().toString().trim();
                final String pass = pwd.getText().toString().trim();
                final String name = nom.getText().toString();
                final String date = dateN.getText().toString().trim();
                final String tele = Ntele.getText().toString().trim();

                if (TextUtils.isEmpty(tele)) {
                    Ntele.setError("Veuillez saisir votre E-Mail");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    pwd.setError("Veuillez saisir un mot de passe");
                    return;
                }
                if (pass.length() < 6 ) {
                    if(pass.length() ==0)
                        pwd.setError("Veuillez saisir un mot de passe ");
                    else
                        pwd.setError("mdp doit avoir plus que 5 caractères ");
                    return;
                }
                if(TextUtils.isEmpty(mail)) {
                    email.setError("Veuillez saisir votre E-Mail");
                    return;
                }
                if(TextUtils.isEmpty(date)) {
                    dateN.setError("Veuillez saisir votre date de naissance");
                    return;
                }
                if(TextUtils.isEmpty(name)) {
                    nom.setError("Veuillez saisir votre Nom");
                    return;
                }
                fauth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(registerActivity.this,"Utilisateur créé avec succès",Toast.LENGTH_SHORT).show();
                            usrID = fauth.getCurrentUser().getUid();
                            DocumentReference docRef = fStore.collection("users").document(usrID);
                            Map<String,Object> users = new HashMap<>();
                            users.put("Full name",name);
                            users.put("Email",mail);
                            users.put("telephone number",tele);
                            users.put("birth date",date);
                            docRef.set(users);

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else {Toast.makeText(registerActivity.this,"Erreur ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }});
    }
}