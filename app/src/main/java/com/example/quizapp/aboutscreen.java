package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutscreen extends AppCompatActivity
{
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutscreen);

        back = (Button)findViewById(R.id.buttonback);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i_back = new Intent(getApplicationContext(),Mainscreen.class);
                startActivity(i_back);
            }
        });
    }
}