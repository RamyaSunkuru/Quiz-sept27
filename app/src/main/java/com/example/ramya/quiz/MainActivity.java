package com.example.ramya.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button nextButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton =  findViewById(R.id.button);
        editText =  findViewById(R.id.editText);

        nextButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String userName = editText.getText().toString();
        if(TextUtils.isEmpty(userName)) {
            editText.setError("Please, Enter your name");
            return;
        }
        Intent intent = new Intent(MainActivity.this,InstructionsActivity.class);
       // intent.putExtra(userName,"username");
        SharedPreferences myPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor =myPref.edit();
        editor.putString("username",userName);
        editor.commit();
        startActivity(intent);
        finish();
    }
}
