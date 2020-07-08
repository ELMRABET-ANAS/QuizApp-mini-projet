package com.pk.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profil_activity extends AppCompatActivity {

    TextView Nom;
    TextView email;
    TextView birthday;
    TextView tele;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String usrID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        fAuth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        usrID = fAuth.getCurrentUser().getUid();
        Nom = findViewById(R.id.linLayout).findViewById(R.id.usrName);
        birthday = findViewById(R.id.linLayout2).findViewById(R.id.birth);
        email = findViewById(R.id.linLayout3).findViewById(R.id.email);
        tele = findViewById(R.id.linLayout4).findViewById(R.id.phone);



        DocumentReference docRef = fStore.collection("users").document(usrID);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {

            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                Nom.setText(documentSnapshot.getString("Full name"));
                birthday.setText(documentSnapshot.getString("birth date"));
                email.setText(documentSnapshot.getString("Email"));
                tele.setText(documentSnapshot.getString("telephone number"));
            }
        });
    }
}