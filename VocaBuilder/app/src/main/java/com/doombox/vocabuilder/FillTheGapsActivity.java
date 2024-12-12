package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.doombox.vocabuilder.DataModels.FillTheGapModel;

public class FillTheGapsActivity extends AppCompatActivity {

    //----------------------Declarer variable for XML element---------------------------//
    TextView questionTxt;
    EditText userInputEditTxt;
    ProgressBar progressBar;
    Button checkAnswerBtn;
    Dialog dialog;

    //-------------------Declare variable for functionality---------------//
    String userInput;
    String finalSentence, finalWord;
    String[] word, meaning, example;

    FillTheGapModel[] questionSet;
    int currentIndex = 0;
    String currentQuestion;

    int score = 10;
    final int progress = (int) Math.ceil(100/score);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_the_gaps);

        //--------------------declare all method--------------------------//
        typeCast();
        dialog = new Dialog(this);


        //------------------Get data from FlashCard activity-------------------//
        Intent intent = getIntent();
        word = intent.getStringArrayExtra("word");
        meaning = intent.getStringArrayExtra("meaning");
        example = intent.getStringArrayExtra("example");


        //--------------------set Question on an ArrayList-------------------//
        questionSet = new FillTheGapModel[]{

                new FillTheGapModel(example[0],word[0]),
                new FillTheGapModel(example[1],word[1]),
                new FillTheGapModel(example[2],word[2]),
                new FillTheGapModel(example[3],word[3]),
                new FillTheGapModel(example[4],word[4])
        };


        //--------------------------------make Question-------------------------------//

        finalSentence = questionSet[currentIndex].getQuestion().toLowerCase();
        finalWord = questionSet[currentIndex].getWord().toLowerCase();

        if (finalSentence.contains(finalWord)){
            String question = finalSentence.replace(finalWord,"____________");

            String firstChar = String.valueOf(question.charAt(0)) ;
            currentQuestion = question.replace(firstChar,firstChar.toUpperCase());
            questionTxt.setText(currentQuestion);

        }



        checkAnswerBtn.setOnClickListener(v -> {

            userInput = userInputEditTxt.getText().toString();
            checkAnswer(userInput);
        });


    }


    private void typeCast() {

        questionTxt = this.findViewById(R.id.FillGap_exampleTextId);
        userInputEditTxt = this.findViewById(R.id.FillGap_userInputId);
        progressBar = this.findViewById(R.id.FillGap_progressBarId);
        checkAnswerBtn = this.findViewById(R.id.FillGap_checkAnswerBtnId);

    }



    private void checkAnswer(String userInput) {

        if (userInput.toLowerCase().equals(finalWord)){

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            userInputEditTxt.setText("",TextView.BufferType.EDITABLE);
            updateQuestion();

            progressBar.incrementProgressBy(progress);
            String finalProgress = String.valueOf( progressBar.getProgress());

            if (finalProgress.equals("100")){


                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);

            }

        } else {

            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
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

    private void updateQuestion() {

        currentIndex = (currentIndex+1)%questionSet.length;

        finalSentence = questionSet[currentIndex].getQuestion().toLowerCase();
        finalWord = questionSet[currentIndex].getWord().toLowerCase();

        if (finalSentence.contains(finalWord)){
            String question = finalSentence.replace(finalWord,"____________");

            String firstChar = String.valueOf(question.charAt(0)) ;
            currentQuestion = question.replace(firstChar,firstChar.toUpperCase());
            questionTxt.setText(currentQuestion);

        }

    }

}