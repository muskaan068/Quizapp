package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultscreen extends AppCompatActivity
{
    TextView tvcorrect, tvwrong, tvfinal;
    Button restart;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultscreen);

        tvcorrect = (TextView)findViewById(R.id.tvcorrectans);
        tvwrong = (TextView)findViewById(R.id.tvwrongans);
        tvfinal = (TextView)findViewById(R.id.tvfinalscore);
        restart = (Button)findViewById(R.id.buttonrestart);

        int c_ans, w_ans, f_Score;

        Intent i1 = getIntent();
        StringBuffer crct = new StringBuffer();
        c_ans = i1.getIntExtra("correct",0);
        crct.append("Correct answers: "+c_ans);

        StringBuffer wrng = new StringBuffer();
        w_ans = i1.getIntExtra("wrong",0);
        wrng.append("Wrong answers: "+w_ans);

        StringBuffer fl = new StringBuffer();
        f_Score = i1.getIntExtra("final",0);
        fl.append("Final Score: "+f_Score);

        tvcorrect.setText(crct);
        tvwrong.setText(wrng);
        tvfinal.setText(fl);

        restart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), Mainscreen.class);
                startActivity(i);
            }
        });
    }
}