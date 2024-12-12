package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateVocabActivity extends AppCompatActivity {

    EditText wordInput, meaningInput, exampleInput;
    Button updateButton;
    String tableName, id, word, meaning, example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vocab);


        typecast();
        getAndSetIntentData();

        updateButton.setOnClickListener(v -> {
            MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(getApplicationContext());
            word = wordInput.getText().toString().trim();
            meaning = meaningInput.getText().toString().trim();
            example = exampleInput.getText().toString().trim();

            if (tableName.equals("1")){
                myDataBaseHelper.updateDataToLearn(id,word,meaning,example);
            } else if (tableName.equals("2")){
                myDataBaseHelper.updateDataLearned(id,word,meaning,example);
            }

        });


    }

    private void typecast() {

        wordInput = findViewById(R.id.updateWordEditTextId);
        meaningInput = findViewById(R.id.updateMeaningEditTextId);
        exampleInput = findViewById(R.id.updateExampleEditTextId);
        updateButton = findViewById(R.id.updateBtnId);
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("tableName")
                 && getIntent().hasExtra("id")
                 && getIntent().hasExtra("word")
                 && getIntent().hasExtra("meaning")
                 && getIntent().hasExtra("example")){
            //Getting Data from Intent
            tableName = getIntent().getStringExtra("tableName");
            id = getIntent().getStringExtra("id");
            word = getIntent().getStringExtra("word");
            meaning = getIntent().getStringExtra("meaning");
            example = getIntent().getStringExtra("example");

            //Setting Intent Data
            wordInput.setText(word);
            meaningInput.setText(meaning);
            exampleInput.setText(example);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}