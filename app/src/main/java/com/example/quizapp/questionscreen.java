package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class questionscreen extends AppCompatActivity
{
    TextView display, tvforques, score;
    String testtakername;
    Button submit, quit;
    RadioGroup rg;
    RadioButton rbA, rbB, rbC, rbD;
    int correct=0, wrong=0, marks=0;
    int flag = 0;
    String questions[] = {"Which method can be defined only once in a program?",
                          "Which keyword is used by method to refer to the current objec that invoked it?",
                          "Which of these access specifiers can be used for an interface?",
                          "Which of the following is the correct way of importing an entire package '.pkg'?",
                          "What is the return type of Constructors?"};

    String options[] = {"finalize method","main method","static method","private method",
                        "import","this","catch","abstract",
                        "public","protected","private","All of the mentioned",
                        "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
                        "int","float","void","None of the mentioned"};

    String answers[] = {"main method","this","public","import pkg.*","None of the mentioned"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionscreen);

        display = (TextView)findViewById(R.id.displayname);
        Intent i2 = getIntent();
        testtakername = i2.getStringExtra("myname");
        if (testtakername.trim().equals(""))
            //Toast.makeText(getApplicationContext(),"First enter your name to start",Toast.LENGTH_LONG).show();
            display.setText("Hello Quizzer");
        else
            display.setText("Hello "+testtakername);

        tvforques = (TextView)findViewById(R.id.tvques);
        score = (TextView)findViewById(R.id.tvyourscorenumber);
        submit = (Button)findViewById(R.id.buttonnextques);
        quit = (Button)findViewById(R.id.buttonquitquiz);

        rg = (RadioGroup)findViewById(R.id.rgmain);
        rbA = (RadioButton)findViewById(R.id.optionA);
        rbB = (RadioButton)findViewById(R.id.optionB);
        rbC = (RadioButton)findViewById(R.id.optionC);
        rbD = (RadioButton)findViewById(R.id.optionD);
        tvforques.setText(questions[flag]);
        rbA.setText(options[0]);
        rbB.setText(options[1]);
        rbC.setText(options[2]);
        rbD.setText(options[3]);

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(rg.getCheckedRadioButtonId()==-1) //if the user proceeds without selecting any option
                {
                    Toast.makeText(getApplicationContext(),"Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton ans = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
                String anstext = ans.getText().toString();
                Toast.makeText(getApplicationContext(), anstext, Toast.LENGTH_SHORT).show();

                if(anstext.equals(answers[flag]))
                {
                    Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
                    correct++;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong", Toast.LENGTH_SHORT).show();
                    wrong++;
                }
                flag=flag+1;
                if(score!=null)
                {
                    score.setText(""+correct);
                }

                if(flag<questions.length)
                {
                    tvforques.setText(questions[flag]);
                    rbA.setText(options[flag*4]);
                    rbB.setText(options[flag*4 + 1]);
                    rbC.setText(options[flag*4 + 2]);
                    rbD.setText(options[flag*4 + 3]);
                }
                else
                {
                    marks = correct;
                    Intent intent = new Intent(getApplicationContext(),resultscreen.class);
                    startActivity(intent);
                    Intent i1 = new Intent(getApplicationContext(),resultscreen.class);

                    i1.putExtra("correct",correct);

                    i1.putExtra("wrong", wrong);

                    i1.putExtra("final", correct);
                    startActivity(i1);
                }
                rg.clearCheck(); //clearing the radio button
            }
        });

        quit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(getApplicationContext(), resultscreen.class);
                startActivity(intent2);
            }
        });
    }
}