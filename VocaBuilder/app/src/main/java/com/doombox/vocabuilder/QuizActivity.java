package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.doombox.vocabuilder.DataModels.QuizModel;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    //----------------------Declarer variable for XML element---------------------------//
    TextView questionTxt, option1Txt, option2Txt, option3Txt, option4Txt;
    ProgressBar progressBar;
    Dialog dialog;


    //-------------------Declare variable for functionality---------------//
    String[] word, meaning, example;
    QuizModel[] answerSet;
    int currentIndex = 0;

    String currentQ, currentO1,currentO2,currentO3,currentO4;
    int score = 10;
    final int progress = (int) Math.ceil(100/score);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        /*---------------------- Call all Methods---------------*/
        typeCast();
        option1Txt.setOnClickListener(this);
        option2Txt.setOnClickListener(this);
        option3Txt.setOnClickListener(this);
        option4Txt.setOnClickListener(this);
        dialog = new Dialog(this);


        /*-----------------------Get data from FlashCard activity---------------*/
        Intent intent = getIntent();
        if (intent.hasExtra("word")){

            word = intent.getStringArrayExtra("word");
            meaning = intent.getStringArrayExtra("meaning");
            example = intent.getStringArrayExtra("example");

        }





        /*----------------------make Question----------------*/
        String question = "What is the meaning of ";
        answerSet = new QuizModel[]{

                new QuizModel(question+word[0]+" ?",meaning[1],meaning[0],meaning[2],meaning[3],meaning[0]),
                new QuizModel(question+word[1]+" ?",meaning[0],meaning[2],meaning[1],meaning[3],meaning[1]),
                new QuizModel(question+word[2]+" ?",meaning[2],meaning[1],meaning[0],meaning[3],meaning[2]),
                new QuizModel(question+word[3]+" ?",meaning[3],meaning[1],meaning[4],meaning[2],meaning[3]),
                new QuizModel(question+word[4]+" ?",meaning[0],meaning[1],meaning[2],meaning[4],meaning[4])

        };



        /*----------------------show First Question----------------*/

        currentQ = answerSet[currentIndex].getQuestion();
        questionTxt.setText(currentQ);
        currentO1 = answerSet[currentIndex].getOption1();
        option1Txt.setText(currentO1);
        currentO2 = answerSet[currentIndex].getOption2();
        option2Txt.setText(currentO2);
        currentO3 = answerSet[currentIndex].getOption3();
        option3Txt.setText(currentO3);
        currentO4 = answerSet[currentIndex].getOption4();
        option4Txt.setText(currentO4);

    }

    /**---------------------Typecast all element----------------*/
    private void typeCast() {
        questionTxt = findViewById(R.id.questionTxtId);
        option1Txt = findViewById(R.id.option1TxtId);
        option2Txt = findViewById(R.id.option2TxtId);
        option3Txt = findViewById(R.id.option3TxtId);
        option4Txt = findViewById(R.id.option4TxtId);
        progressBar = findViewById(R.id.progressBarId);
    }


    /**---------------------onClick method---------------*/
    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.option1TxtId){


            checkAnswer(currentO1);



        } else if (v.getId()==R.id.option2TxtId){


            checkAnswer(currentO2);


        } else if (v.getId()==R.id.option3TxtId){

            checkAnswer(currentO3);



        } else if (v.getId()==R.id.option4TxtId){

            checkAnswer(currentO4);

        }


    }


    /**----------------------Check answer method----------------*/

    private void checkAnswer(String userSelection) {

        String currentAnswer = answerSet[currentIndex].getAnswer();


        if (userSelection.equals(currentAnswer)){

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            updateQuestion();

            progressBar.incrementProgressBy(progress);
            String finalProgress = String.valueOf( progressBar.getProgress());

            if (finalProgress.equals("100")){


                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);


            }

        } else {

            showWrongDialog(currentIndex);


        }


    }

    private void showWrongDialog(int currentIndex) {

        dialog.setContentView(R.layout.dialog_quizactivity_wronganswer);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView wordText = dialog.findViewById(R.id.currectWord);
        TextView meaningText = dialog.findViewById(R.id.currectMeaning);
        TextView exampleText = dialog.findViewById(R.id.currectExample);

        wordText.setText(word[currentIndex]);
        meaningText.setText(meaning[currentIndex]);
        exampleText.setText(example[currentIndex]);
        dialog.show();

    }

    /**----------------------update question method-----------------*/

    private void updateQuestion(){

        /*---------------------make index loop----------------*/
        currentIndex = (currentIndex+1)%answerSet.length;

        /*---------------------set question set----------------*/
        currentQ = answerSet[currentIndex].getQuestion();
        questionTxt.setText(currentQ);
        currentO1 = answerSet[currentIndex].getOption1();
        option1Txt.setText(currentO1);
        currentO2 = answerSet[currentIndex].getOption2();
        option2Txt.setText(currentO2);
        currentO3 = answerSet[currentIndex].getOption3();
        option3Txt.setText(currentO3);
        currentO4 = answerSet[currentIndex].getOption4();
        option4Txt.setText(currentO4);

    }


}