package com.anish.playquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Dashboard extends AppCompatActivity {
    Button answer1,answer2,answer3,answer4;
    TextView score, question,tvUn;


    private Questions mQuestions= new Questions();

    private String mAnswer;
    private int mScore=0;
    private int mQuestionLength=mQuestions.mQuestions.length;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        r= new Random();
        tvUn=(TextView)findViewById(R.id.tvUn);
        Intent intent=getIntent();
        String userName=intent.getStringExtra("USERNAME");
        tvUn.setText(userName);



        answer1=(Button)findViewById(R.id.btnAns1);
        answer2=(Button)findViewById(R.id.btnAns2);
        answer3=(Button)findViewById(R.id.btnAns3);
        answer4=(Button)findViewById(R.id.btnAns4);

        score=(TextView)findViewById(R.id.tbScore);
        question=(TextView)findViewById(R.id.tbQuestion);

        updateQuestion(r.nextInt(mQuestionLength) );

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answer1.getText()==mAnswer)
                {
                    mScore++;
                    score.setText("Score :" +mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText()==mAnswer)
                {
                    mScore++;
                    score.setText("Score :" +mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {
                    gameOver();
                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText()==mAnswer)
                {
                    mScore++;
                    score.setText("Score :" +mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {

               gameOver();
                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText()==mAnswer)
                {
                    mScore++;
                    score.setText("Score :" +mScore);
                    updateQuestion(r.nextInt(mQuestionLength));
                }
                else
                {
                    gameOver();
                }

            }
        });
    }

    private void updateQuestion(int num)
    {
        question.setText(mQuestions.getQuestions(num));
        answer1.setText(mQuestions.getChoice(num));
        answer2.setText(mQuestions.getChoice1(num));
        answer3.setText(mQuestions.getChoice2(num));
        answer4.setText(mQuestions.getChoice3(num));
         mAnswer=mQuestions.getCorrectAnswer(num);

    }

    private void gameOver()
    {
        AlertDialog.Builder alertDialogBuider= new AlertDialog.Builder(Dashboard.this);
        alertDialogBuider
                .setMessage("Game Over!Your Score is" +mScore + "points")
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    startActivity(new Intent(getApplicationContext(),Dashboard.class));


                    finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuider.create();
        alertDialog.show();

    }



}
