package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mainscreen extends AppCompatActivity
{
    Button start,about;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        start = (Button)findViewById(R.id.button12);
        about = (Button)findViewById(R.id.button13);
        name = (EditText)findViewById(R.id.personname);

        about.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i1 = new Intent(getApplicationContext(), aboutscreen.class);
                startActivity(i1); //takes to the about screen
            }
        });

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String testtakername = name.getText().toString();
                Intent i2 = new Intent(getApplicationContext(), questionscreen.class);
                i2.putExtra("myname",testtakername);
                startActivity(i2);
            }
        });
    }
}