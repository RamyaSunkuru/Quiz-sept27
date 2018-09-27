package com.example.ramya.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ScoreBoardActivity extends AppCompatActivity {
    TextView currentScore , highestScore ,userText;
    Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        highestScore = findViewById(R.id.highScore);
        currentScore= findViewById(R.id.yourScore);
        closeButton= findViewById(R.id.close);
        userText= findViewById(R.id.user);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        currentScore.setText("Your Score : "+ score);

        SharedPreferences myPref = getPreferences(MODE_PRIVATE);
        SharedPreferences userPref = PreferenceManager.getDefaultSharedPreferences(this);
        String name = userPref.getString("username","");
        userText.setText("HeLLO !  " + name);
        int highScore = myPref.getInt("highscore",0);
        if(highScore>=score){
            highestScore.setText("Highest Score : "+ highScore);

        }
        else {
            highestScore.setText("New High Score : "+ score);
            SharedPreferences.Editor editor = myPref.edit();
            editor.putInt("highscore",score);
            editor.commit();


        }

    }
}
