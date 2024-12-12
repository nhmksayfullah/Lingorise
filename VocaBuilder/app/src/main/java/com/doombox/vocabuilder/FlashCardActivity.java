package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlashCardActivity extends AppCompatActivity implements View.OnClickListener {

    String[] word, meaning, example;
    TextView wordText, meaningText, exampleText;
    Button previousBtn, nextBtn;
    LinearLayout flashCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        typeCast();
        previousBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);


        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            word = bundle.getStringArray("word");
            meaning = bundle.getStringArray("meaning");
            example = bundle.getStringArray("example");

            wordText.setText(word[0]);
            meaningText.setText(meaning[0]);
            exampleText.setText(example[0]);
        }




    }


    void typeCast(){

        wordText = this.findViewById(R.id.flashCardWordTxtId);
        meaningText = this.findViewById(R.id.flashCardMeaningTxtId);
        exampleText = this.findViewById(R.id.flashCardExampleTxtId);
        previousBtn = this.findViewById(R.id.previousBtnId);
        nextBtn = this.findViewById(R.id.nextBtnId);
//        flashCardView = this.findViewById(R.id.flashCardViewId);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.previousBtnId){

            if (wordText.getText().toString().equals(word[1])){
                previousBtn.setVisibility(View.INVISIBLE);

                wordText.setText(word[0]);
                meaningText.setText(meaning[0]);
                exampleText.setText(example[0]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));

            }
            else if (wordText.getText().toString().equals(word[2])){
                previousBtn.setVisibility(View.VISIBLE);

                wordText.setText(word[1]);
                meaningText.setText(meaning[1]);
                exampleText.setText(example[1]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));


            }
            else if (wordText.getText().toString().equals(word[3])){
                previousBtn.setVisibility(View.VISIBLE);

                wordText.setText(word[2]);
                meaningText.setText(meaning[2]);
                exampleText.setText(example[2]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));
            }
            else if (wordText.getText().toString().equals(word[4])){
                previousBtn.setVisibility(View.VISIBLE);
                nextBtn.setText("Next");
                wordText.setText(word[3]);
                meaningText.setText(meaning[3]);
                exampleText.setText(example[3]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));
            }



        }
        if (v.getId()==R.id.nextBtnId){

            if (wordText.getText().toString().equals(word[0])){
                previousBtn.setVisibility(View.VISIBLE);

                wordText.setText(word[1]);
                meaningText.setText(meaning[1]);
                exampleText.setText(example[1]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));
            }
            else if (wordText.getText().toString().equals(word[1])){

                wordText.setText(word[2]);
                meaningText.setText(meaning[2]);
                exampleText.setText(example[2]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));
            }
            else if (wordText.getText().toString().equals(word[2])){

                wordText.setText(word[3]);
                meaningText.setText(meaning[3]);
                exampleText.setText(example[3]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));
            }
            else if (wordText.getText().toString().equals(word[3])){
                nextBtn.setText("Play");

                wordText.setText(word[4]);
                meaningText.setText(meaning[4]);
                exampleText.setText(example[4]);
                flashCardView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_flash_card_3));

            }
            else if(wordText.getText().toString().equals(word[4])) {
                Intent intent = new Intent(FlashCardActivity.this,GameWhichPlayActivity.class);
                intent.putExtra("word", word);
                intent.putExtra("meaning", meaning);
                intent.putExtra("example", example);

                startActivity(intent);
                finish();
            }


        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {

         startActivity(new Intent(this,MainActivity.class));
         finish();


        }
        return super.onKeyDown(keyCode, event);
    }



}