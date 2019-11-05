package com.example.aptitudequiz;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.content.Intent;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result2 extends AppCompatActivity {
    TextView tv, tv2, tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView) findViewById(R.id.tvres);
        tv2 = (TextView) findViewById(R.id.tvres2);
        tv3 = (TextView) findViewById(R.id.tvres3);
        Button restart = (Button) findViewById(R.id.btnRestart);


        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + Question2.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + Question2.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + Question2.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Question2.correct = 0;
        Question2.wrong = 0;

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), SelectYear.class);
                startActivity(in);
            }
        });



    }

}