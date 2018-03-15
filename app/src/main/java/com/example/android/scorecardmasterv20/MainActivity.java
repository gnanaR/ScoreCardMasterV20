package com.example.android.scorecardmasterv20;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    GridLayout grid;

    int scoreTeamA=0;

      int scoreTeamB=0;

    TextView timerView, txtCount;
    Button btnCount, btnRestart;
    int count =0;
    boolean[] timerProcessing={false};
    boolean[] timerStarts={false};
    private MyCount timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtCount =(TextView) findViewById(R.id.txtCount);
        txtCount.setText(String.valueOf(count));
        btnCount=(Button) findViewById(R.id.startTimer);
        btnRestart=(Button) findViewById(R.id.resetScore);

        timerView=(TextView)findViewById(R.id.timerView);

        timer=new MyCount(1800000,60);

      btnCount.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View arg0) {

              if (!timerStarts[0]){
                  timer.start();
                  timerStarts[0]=true;
                  timerProcessing[0]=true;
              }
              if (timerProcessing[0]){
                  count++;
                  txtCount.setText(String.valueOf(count));
              }
              if (timerProcessing[0]){
                  count=0;
                  timer.start();
              }


          }
      });

      btnRestart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              timerProcessing[0]=true;
              count=0;
              txtCount.setText(String.valueOf(count));
              timer.cancel();
              displayForTimer();
              //timer.start();

              /**
               * Reset Score for teams.
               */
                  scoreTeamA = 0;
                  displayForTeamA(scoreTeamA);
                  scoreTeamB = 0;
                  displayForTeamB(scoreTeamB);

                  CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
                  checkBox1.setChecked(false);

                  CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
                  checkBox2.setChecked(false);

                  CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
                  checkBox3.setChecked(false);

                  CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
                  checkBox4.setChecked(false);

                  CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
                  checkBox5.setChecked(false);

                  CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
                  checkBox6.setChecked(false);

                  CheckBox checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
                  checkBox7.setChecked(false);

                  CheckBox checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
                  checkBox8.setChecked(false);

                  CheckBox checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
                  checkBox9.setChecked(false);

                  CheckBox checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
                  checkBox10.setChecked(false);

                  CheckBox checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
                  checkBox11.setChecked(false);

                  CheckBox checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
                  checkBox12.setChecked(false);



          }
      });

            }

    /**
     * Increase the score for Team A by 1 points.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays for timer.
     */
    public void displayForTimer() {
        TextView timerView = (TextView) findViewById(R.id.timerView);
        timerView.setText("PRESS START TIMER");

    }

            public class MyCount extends CountDownTimer{
        public MyCount(long millisInFuture,long countDownInterval){
            super(millisInFuture,countDownInterval);
        }

        @Override
                public void onFinish(){
            timerView.setText("0.000");
            timerProcessing[0]=false;

        }

        @Override
                public void onTick(long millisUntilFinished){
                    timerView.setText(""+millisUntilFinished/1000+" Seconds Remaining");
        }

            }




}
