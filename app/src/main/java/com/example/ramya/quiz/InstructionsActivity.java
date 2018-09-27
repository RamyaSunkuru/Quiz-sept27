package com.example.ramya.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class InstructionsActivity extends AppCompatActivity implements OnClickListener {
   Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        testButton =  findViewById(R.id.startButton);
        testButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(InstructionsActivity.this,QuizActivity.class);
        startActivity(intent);
        finish();
    }
}
