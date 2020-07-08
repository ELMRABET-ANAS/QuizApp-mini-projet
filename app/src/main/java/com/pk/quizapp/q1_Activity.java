package com.pk.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class q1_Activity extends AppCompatActivity {

    public static final String yourScore ="int value";
    RadioGroup rg;
    Button btn_next;
    RadioButton rb1;
    RadioButton rb2;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        rg=findViewById(R.id.RG);
        btn_next=findViewById(R.id.BtnNext);
        rb1 = findViewById(R.id.Rb1);
        rb2 = findViewById(R.id.Rb2);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rg.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(q1_Activity.this, "Veuillez selectionner une réponse !", Toast.LENGTH_SHORT).show();
                }else
                {

                    Intent intent=new Intent(q1_Activity.this,q2_Activity.class);
                    q1_Activity.this.finish();

                    if(rg.getCheckedRadioButtonId()==rb1.getId())
                    {
                        score=0;
                        score++;
                    }
                    if(rg.getCheckedRadioButtonId()==rb2.getId())
                    {
                        score=0;
                    }
                    intent.putExtra(yourScore,score);

                    startActivity(intent);
                }
            }
        });
    }
}