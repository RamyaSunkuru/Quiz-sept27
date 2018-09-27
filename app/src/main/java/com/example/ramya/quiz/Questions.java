package com.example.ramya.quiz;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "QuestionsTable")
class Questions {
    @PrimaryKey
    public int id;
    public String question_string;
    public String option_one;
    public String option_two;
    public String option_three;
    public String option_four;
    public String answer_string;
    public int question_weight;

  public  Questions(int id,String question_string,String option_one,String option_two,String option_three,String option_four,String answer_string,int question_weight){
      this.id= id;
      this.question_string= question_string;
      this.option_one= option_one;
      this.option_two= option_two;
      this.option_three= option_three;
      this.option_four= option_four;
      this.answer_string = answer_string;
      this.question_weight= question_weight;
  }

  @Ignore
    public Questions(int id,String question_string,String option_one,String option_two,String option_three,String option_four){
        this.id= id;
        this.question_string= question_string;
        this.option_one= option_one;
        this.option_two= option_two;
        this.option_three= option_three;
        this.option_four= option_four;
    }

  public void setId(int id){
        this.id=id;
  }
  public int getId(){
      return id;
  }
  public void setQuestion_string(String question_string){
      this.question_string= question_string;
    }
  public  String getQuestion_string(){
      return question_string;
  }
  public void setOption_one(String option_one){
      this.option_one= option_one;
  }
  public String getOption_one(){
      return option_one;
  }
    public void setOption_two(String option_two){
        this.option_two= option_two;
    }
    public String getOption_two(){
        return option_two;
    }
    public void setOption_three(String option_three){
        this.option_three= option_three;
    }
    public String getOption_three(){
        return option_three;
    }
    public void setOption_four(String option_four){
        this.option_four= option_one;
    }
    public String getOption_four(){
        return option_four;
    }
    public void setAnswer_string(String answer_string){
        this.answer_string=answer_string;
    }
    public String getAnswer_string(){
        return answer_string;
    }
    public void setQuestion_weight(int question_weight){
        this.question_weight = question_weight;
    }
    public  int getQuestion_weight(){
        return  question_weight;
    }
    public static Questions[] populateData() {
        return new Questions[] {

       new Questions(1, "choose the best definition: ABROGATE", "take aggressively", "overturn a law", "side with", "bring into existence", "overturn a law", 2),
       new Questions(2," All good comic writers use humor to ____, not to side-step the problems of human behavior."," amuse","avert","solve","confront","confront",2),
       new Questions(3,"Select the word which is OPPOSITE in the meaning: INDISCREET","reliable","honest","prudent","support","prudent",2),
       new Questions(4,"Find the closest antonym for the word:ECONOMICAL","frugal","wasteful","efficient","plain","wasteful",2),
       new Questions(5,"Look at this series: 36, 34, 30, 28, 24, ... What number should come next?","20","22","23","26","22",3),
       new Questions(6,"FAG, GAF, HAI, IAH, ____","JAK","HAL","HAK","JAI","JAK",3),
       new Questions(7,"A, P, R, X, S and Z are sitting in a row. S and Z are in the centre. A and P are at the ends. R is sitting to the left of A. Who is to the right of P ?","A","X","S","Z","X",3),
       new Questions(8,"A's son B is married with C whose sister D is married to E the brother of B. How D is related to A?","sister","daughters in law","sister in law","cousin","daughters in law",3),
       new Questions(9,"Sakshi can do a piece of work in 20 days. Tanya is 25% more efficient than Sakshi. The number of days taken by Tanya to do the same piece of work is:","15","16","18","25","16",5),
       new Questions(10,"A train passes a station platform in 36 seconds and a man standing on the platform in 20 seconds. If the speed of the train is 54 km/hr, what is the length of the platform?","120 m","240 m","300 m","none of these","240 m",5)

        };
    }


}