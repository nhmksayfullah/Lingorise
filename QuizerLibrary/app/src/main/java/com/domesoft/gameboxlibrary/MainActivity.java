package com.domesoft.gameboxlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.domesoft.gamebox.fillthegap.FillData;
import com.domesoft.gamebox.fillthegap.GapBuilder;
import com.domesoft.gamebox.quizer.Quiz;
import com.domesoft.gamebox.quizer.Quizer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvQ, tvO1, tvO2, tvO3, tvO4;
    EditText editText;
    ProgressBar progressBar;
    TextView tvTimer;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQ = findViewById(R.id.tvQ);
        tvO1 = findViewById(R.id.tvO1);
        tvO2 = findViewById(R.id.tvO2);
        tvO3 = findViewById(R.id.tvO3);
        tvO4 = findViewById(R.id.tvO4);


//        editText = findViewById(R.id.editText);
//        progressBar = findViewById(R.id.progressBar);
//        tvTimer = findViewById(R.id.tvTimer);
//        btnCheck = findViewById(R.id.btnCheck);

//        List<FillData> questionSet = new ArrayList<>();
//
//        questionSet.add(new FillData("Abid is Abide","Abide"));
//        questionSet.add(new FillData("Hell is Hello","Hello"));
//        questionSet.add(new FillData("Kil is Kill","Kill"));
//
//        GapBuilder gapBuilder = new GapBuilder(this);
//        gapBuilder.setPrimaryElement(tvQ,editText,btnCheck)
//                .setQuestion(questionSet)
//                .setProgressBar(progressBar)
//                .setTimerForAllQuestion(tvTimer, 30)
//                .create();
//
//        gapBuilder.setOnSuccessListener(currentPosition ->
//                Toast.makeText(MainActivity.this, "Wow", Toast.LENGTH_SHORT).show()
//        ).setOnFailureListener(currentPosition ->
//                Toast.makeText(MainActivity.this, "Oh Noop", Toast.LENGTH_SHORT).show()
//        ).setOnTimeUpListener(finalScore ->
//                        Toast.makeText(this, String.valueOf(finalScore), Toast.LENGTH_SHORT).show()
//                );







        List<Quiz> myQuiz = new ArrayList<>();

        myQuiz.add(new Quiz("what is the meaning of A","A","2","3","4","A"));
        myQuiz.add(new Quiz("what is the meaning of B","B","2","3","4","B"));
        myQuiz.add(new Quiz("what is the meaning of C","C","2","3","4","C"));
        myQuiz.add(new Quiz("what is the meaning of D","D","2","3","4","D"));
        myQuiz.add(new Quiz("what is the meaning of E","E","2","3","4","E"));
        myQuiz.add(new Quiz("what is the meaning of F","F","2","3","4","F"));

        Quizer quizer = new Quizer(this);
        quizer.setPrimaryElement(tvQ,tvO1,tvO2,tvO3,tvO4).setQuizList(myQuiz).setOptionRandomly();
        //quizer.setProgressBar(progressBar);

//        quizer.setOnSuccessListener(currentPosition ->
//
//                        Toast.makeText(MainActivity.this,String.valueOf(currentPosition), Toast.LENGTH_SHORT).show()
//        )
//
//                .setOnFailureListener(currentPosition ->
//                        Toast.makeText(MainActivity.this, "Correct answer is "+ myQuiz.get(currentPosition).getAnswer(), Toast.LENGTH_SHORT).show())
//                .setOnFinishedListener(finalScore ->
//                        Toast.makeText(MainActivity.this, "Your score is "+String.valueOf(finalScore), Toast.LENGTH_SHORT).show());
        //int score = 10;
       // quizer.setScore(score,10,tvScore).setSpannable("#FF03DAC5", 23);
        quizer.create();




    }
}