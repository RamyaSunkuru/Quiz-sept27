package com.example.ramya.quiz;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;


public class QuizActivity extends AppCompatActivity  {
    int questionId = 0;
    int score = 0;
    Questions currentQuestion;
    TextView timerText , questionTextView;
    Button nextButton,submitButton ;
    RadioButton optionOne , optionTwo , optionThree, optionFour;
    private static long startTime = 600000;
    private long mTimeLeftInMillis = startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        timerText =  findViewById(R.id.textTimer);
        questionTextView = findViewById(R.id.textQuestion) ;
        nextButton = findViewById(R.id.nextButton);
        submitButton= findViewById(R.id.submitButton);
        optionOne = findViewById(R.id.radioButton1);

        optionTwo= findViewById(R.id.radioButton2);
        optionThree= findViewById(R.id.radioButton3);
        optionFour= findViewById(R.id.radioButton4);

        QuestionsDao appDatabaseDao = AppDatabase.getInstance(this).questionsDao();
        final List<Questions> allQuestions = appDatabaseDao.getAll();
        currentQuestion = allQuestions.get(questionId);
        setQuestionsView();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup group = findViewById(R.id.radioGroup);
                int checkedRadioButton = group.getCheckedRadioButtonId();
                if(checkedRadioButton!= -1) {
                    RadioButton userAnswer = findViewById(checkedRadioButton);
                    group.clearAnimation();
                    group.clearCheck();


                    if (currentQuestion.getAnswer_string().equals(userAnswer.getText())) {
                        score = score + currentQuestion.getQuestion_weight();

                    }
                    if(questionId<10){
                        currentQuestion= allQuestions.get(questionId);
                        setQuestionsView();
                    }else{
                        submitScore();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    SubmitActivity submitActivity;
//                    submitActivity = new SubmitActivity();
//                    submitActivity.show(fragmentManager,"SubmitActivity");
                    }
                }
                else {
                 Toast.makeText(QuizActivity.this,"Please fill the answer",Toast.LENGTH_SHORT).show();

//                 group.clearCheck();
                }



            }
        });

        CountDownTimer countDownTimer = new CountDownTimer(startTime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                submitScore();
//                FragmentManager fragmentManager = getFragmentManager();
//                SubmitActivity submitActivity;
//                submitActivity = new SubmitActivity();
//                submitActivity.show(fragmentManager,"SubmitActivity");
            }
        }.start();
       submitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//
               submitScore();

           }
       });


    }
    private void updateCountDown()
    {
      int minutes = (int) (mTimeLeftInMillis/1000) / 60;
      int seconds = (int) (mTimeLeftInMillis/1000) % 60;
      String timeLeft = String.format(Locale.getDefault(),"%02d:%02d", minutes,seconds);
      timerText.setText(timeLeft);
    }

    public void setQuestionsView()
    {
        questionTextView.setText(currentQuestion.id + ". "+currentQuestion.getQuestion_string());
        optionOne.setText(currentQuestion.getOption_one());
        optionTwo.setText(currentQuestion.getOption_two());
        optionThree.setText(currentQuestion.getOption_three());
        optionFour.setText(currentQuestion.getOption_four());
        questionId++;
    }

    public void submitScore(){
        FragmentManager fragmentManager = getFragmentManager();
        Bundle data = new Bundle();
        data.putInt("mScore",score);
        SubmitActivity submitActivity;
        submitActivity = new SubmitActivity();
        submitActivity.setArguments(data);
        submitActivity.show(fragmentManager,"SubmitActivity");
    }
}
