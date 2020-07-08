package com.pk.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ActivityScore extends AppCompatActivity {

    float score=0;
    Button quitBtn;
    Button restartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        quitBtn = findViewById(R.id.quitBtn);
        restartBtn = findViewById(R.id.restartBtn);
        Intent intent= getIntent();
        int i = intent.getIntExtra(q3_Activity.finalScore,0);

        com.github.lzyzsd.circleprogress.DonutProgress D = findViewById(R.id.donut_progress);
        score = ((float)i/3)*100;
        D.setProgress((int)score);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityScore.this, com.pk.quizapp.q1_Activity.class));
            }
        });

        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ActivityScore.this, com.pk.quizapp.start_Activity.class));
            }
        });

    }
}