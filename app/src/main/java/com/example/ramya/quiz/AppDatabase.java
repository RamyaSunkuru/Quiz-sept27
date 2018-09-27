package com.example.ramya.quiz;


import android.arch.persistence.db.SupportSQLiteDatabase;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import java.util.concurrent.Executors;


@Database(entities = {Questions.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract QuestionsDao questionsDao();
//    RoomDatabase.Callback loadQuestions = new RoomDatabase.Callback() {
//
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            ArrayList<Questions> questionList = new ArrayList<Questions>();
//            questionList.add(new Questions(1, "choose the best definition: ABROGATE", "take aggressively", "overturn a law", "side with", "bring into existence", "overturn a law", 2));
//            questionList.add(new Questions(2," All good comic writers use humor to ____, not to side-step the problems of human behavior."," amuse","avert","solve","confront","confront",2));
//            questionList.add(new Questions(3,"Select the word which is OPPOSITE in the meaning: INDISCREET","reliable","honest","prudent","support","prudent",2));
//            questionList.add(new Questions(4,"Find the closest antonym for the word:ECONOMICAL","frugal","wasteful","efficient","plain","wasteful",2));
//            questionList.add(new Questions(5,"Look at this series: 36, 34, 30, 28, 24, ... What number should come next?","20","22","23","26","22",3));
//            questionList.add(new Questions(6,"FAG, GAF, HAI, IAH, ____","JAK","HAL","HAK","JAI","JAK",3));
//            questionList.add(new Questions(7,"A, P, R, X, S and Z are sitting in a row. S and Z are in the centre. A and P are at the ends. R is sitting to the left of A. Who is to the right of P ?","A","X","S","Z","X",3));
//            questionList.add(new Questions(8,"A's son B is married with C whose sister D is married to E the brother of B. How D is related to A?","sister","daughters in law","sister in law","cousin","daughters in law",3));
//            questionList.add(new Questions(9,"Sakshi can do a piece of work in 20 days. Tanya is 25% more efficient than Sakshi. The number of days taken by Tanya to do the same piece of work is:","15","16","18","25","16",5));
//            questionList.add(new Questions(10,"A train passes a station platform in 36 seconds and a man standing on the platform in 20 seconds. If the speed of the train is 54 km/hr, what is the length of the platform?","120 m","240 m","300 m","none of these","240 m",5));
//}
//
//
//    };
        public  synchronized static AppDatabase getInstance(Context context) {
            if (instance == null) {
              //  instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Questions").addCallback(loadQuestions).allowMainThreadQueries().build();
            instance = buildDatabase(context);
            }
            return instance;

        }

    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "QuestionsTable")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).questionsDao().insertAll(Questions.populateData());
                            }
                        });
                    }
                })
                .allowMainThreadQueries().build();
    }


}




