package com.pk.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class start_Activity extends AppCompatActivity {

    Button startBtn;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startBtn = findViewById(R.id.start);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fauth = FirebaseAuth.getInstance();
        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(start_Activity.this, com.pk.quizapp.q1_Activity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.it1:
                startActivity(new Intent(start_Activity.this, com.pk.quizapp.MapsActivity.class));
                return true;
            case R.id.PROFIL:
                startActivity(new Intent(start_Activity.this, com.pk.quizapp.profil_activity.class));
                return true;
            case R.id.it2:
                fauth.getInstance().signOut();
                start_Activity.this.finish();
                startActivity(new Intent(start_Activity.this, com.pk.quizapp.MainActivity.class));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.munu_res,menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }
}