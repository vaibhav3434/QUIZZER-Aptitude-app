package com.example.aptitudequiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.support.v4.app.*;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?",
            "Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is:",
            "A train 125 m long passes a man, running at 5 km/hr in the same direction in which the train is going, in 10 seconds. The speed of the train is:",
            "If 20% of a = b, then b% of 20 is the same as: ",
            "What least number must be added to 1056, so that the sum is completely divisible by 23 ?",
            "The greatest number of four digits which is divisible by 15, 25, 40 and 75 is: ",
            "A boat can travel with a speed of 13 km/hr in still water. If the speed of the stream is 4 km/hr, find the time taken by the boat to go 68 km downstream. ",
            "A, B and C can do a piece of work in 20, 30 and 60 days respectively. In how many days can A do the work if he is assisted by B and C on every third day?",
            "If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is: ",
            "In how many ways a committee, consisting of 5 men and 6 women can be formed from 8 men and 10 women? "
    };
    String answers[] = {"50400","4:5","50 km/hr","4% of a","2","9600","4 hr","15 days","50 km","11760"};
    String opt[] = {
            "810","1440","2880","50400",
            "2:5","3:5","4:5","6:7",
            "45 km/hr","50 km/hr","54 km/hr","55 km/hr",
            "4% of a","5% of a","20% of a","None of these",
            "2","3","18","21",
            "9000","9400","9600","9800",
            "2 hr","3 hr","4 hr","5 hr",
            "12 days","15 days","16 days","18 days",
            "50 km","56 km","70 km","80 km",
            "266","5040","11760","86400"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);


        final TextView score = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();




        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT);
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT);
                }

                flag++;
                if (score != null)
                    score.setText(""+correct);


                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),Result2.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}