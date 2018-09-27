package com.example.ramya.quiz;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


public interface QuestionsDao  {
    @Query("SELECT * FROM QuestionsTable")
    List<Questions> getAll();

    @Insert
    void insertAll(Questions... questions);

    @Delete
    void delete(Questions questions);
}