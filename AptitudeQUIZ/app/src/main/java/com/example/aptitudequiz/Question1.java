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

public class Question1 extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?",
            "A train 125 m long passes a man, running at 5 km/hr in the same direction in which the train is going, in 10 seconds. The speed of the train is:",
            "A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is:",
            "A fruit seller had some apples. He sells 40% apples and still has 420 apples. Originally, he had:",
            "Which one of the following is not a prime number?",
            "The H.C.F. of two numbers is 23 and the other two factors of their L.C.M. are 13 and 14. The larger of the two numbers is:",
            "A person crosses a 600 m long street in 5 minutes. What is his speed in km per hour?",
            "A can do a work in 15 days and B in 20 days. If they work on it together for 4 days, then the fraction of the work that is left is :",
            "The sum of ages of 5 children born at the intervals of 3 years each is 50 years. What is the age of the youngest child? ",
             "In how many different ways can the letters of the word 'LEADING' be arranged in such a way that the vowels always come together?"
    };
    String answers[] = {"150 metres","50 km/hr","Rs.698","700 apples","91","322"," 7.2","0.53","4 years","720"};
    String opt[] = {
            "120 metres","180 metres","324 metres","150 metres",
            "45 km/hr","50 km/hr","54 km/hr","55 km/hr",
            "Rs.650","Rs.690","Rs.698","Rs.700",
            "588 apples","600 apples","672 apples","700 apples",
            "31","61","71","91",
            "276","299","322","345",
            "3.6","7.2","8.4","10",
            "0.25","0.1","0.46","0.53",
            "4 years","8 years","10 years","None of these",
            "360","480","720","5040"
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
                    Intent in = new Intent(getApplicationContext(),Result.class);
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