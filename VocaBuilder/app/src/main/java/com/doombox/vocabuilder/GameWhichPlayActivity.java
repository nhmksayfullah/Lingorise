package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class  GameWhichPlayActivity extends AppCompatActivity implements View.OnClickListener {

    String[] word, meaning, example;

    View playQuizBtn, playFillGapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_which_play);


        typeCast();
        playQuizBtn.setOnClickListener(this);
        playFillGapBtn.setOnClickListener(this);


        Intent intent = getIntent();
        word = intent.getStringArrayExtra("word");
        meaning = intent.getStringArrayExtra("meaning");
        example = intent.getStringArrayExtra("example");


    }

    private void typeCast() {

        playQuizBtn = findViewById(R.id.playQuizBtnId);
        playFillGapBtn = findViewById(R.id.playFillGapBtnId);

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.playQuizBtnId){


            Intent intent = new Intent(this,QuizActivity.class);
            intent.putExtra("word", word);
            intent.putExtra("meaning", meaning);
            intent.putExtra("example", example);

            startActivity(intent);

        } else if (v.getId()==R.id.playFillGapBtnId){

            Intent intent = new Intent(this,FillTheGapsActivity.class);
            intent.putExtra("word", word);
            intent.putExtra("meaning", meaning);
            intent.putExtra("example", example);

            startActivity(intent);

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