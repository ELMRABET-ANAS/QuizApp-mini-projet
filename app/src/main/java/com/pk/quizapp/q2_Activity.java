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

public class q2_Activity extends AppCompatActivity {

    public static final String finalScore ="int value";
    private int i ;
    private TextView t ;
    Button btnNext;
    RadioGroup Rg;
    RadioButton rb2;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Rg=findViewById(R.id.RG);
        rb2 = findViewById(R.id.Rb2);
        btnNext=findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score=getIntent().getIntExtra(q1_Activity.yourScore,0);

                if(Rg.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(q2_Activity.this, "Veuillez selectionner une réponse !", Toast.LENGTH_SHORT).show();
                }else
                {

                    if(Rg.getCheckedRadioButtonId()==rb2.getId())
                    {
                        score++;
                    }
                    Intent intent=new Intent(q2_Activity.this,q3_Activity.class);
                    q2_Activity.this.finish();

                    intent.putExtra(finalScore,score);
                    startActivity(intent);
                }
            }
        });
    }
}