package com.pk.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class q3_Activity extends AppCompatActivity {

    public static final String finalScore ="int value";
    private int i ;
    private TextView t ;
    Button btnNext;
    RadioGroup Rg;
    RadioButton rb3;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Rg=findViewById(R.id.RG);
        rb3 = findViewById(R.id.Rb3);
        btnNext=findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score=getIntent().getIntExtra(q2_Activity.finalScore,0);

                if(Rg.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(q3_Activity.this, "Veuillez selectionner une réponse !", Toast.LENGTH_SHORT).show();
                }else
                {

                    if(Rg.getCheckedRadioButtonId()==rb3.getId())
                    {
                        score++;
                    }
                    Intent intent=new Intent(q3_Activity.this,ActivityScore.class);
                    q3_Activity.this.finish();

                    intent.putExtra(finalScore,score);
                    startActivity(intent);
                }
            }
        });
    }
}