package com.doombox.vocabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetVocabActivity extends AppCompatActivity implements View.OnClickListener {

    /** *************************declare all variables****************/
    EditText wordInput1, wordInput2, wordInput3, wordInput4, wordInput5,
            meaningInput1, meaningInput2, meaningInput3, meaningInput4, meaningInput5,
            exampleInput1, exampleInput2, exampleInput3, exampleInput4, exampleInput5;
    Button addButton;
    String[] wordList= new String[5];
    String[] meaningList= new String[5];
    String[] exampleList= new String[5];
    MyDataBaseHelper myDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_vocab);

        /* *************************call every methods****************/
        typeCast();
        addButton.setOnClickListener(this);

        /* *************************create myDbHelper instance****************/

        myDataBaseHelper = new MyDataBaseHelper(this);






    }

    /** *************************onCreate methods****************/

    @Override
    public void onClick(View v) {

        wordList[0] = wordInput1.getText().toString();
        wordList[1] = wordInput2.getText().toString();
        wordList[2] = wordInput3.getText().toString();
        wordList[3] = wordInput4.getText().toString();
        wordList[4] = wordInput5.getText().toString();
        meaningList[0] = meaningInput1.getText().toString();
        meaningList[1] = meaningInput2.getText().toString();
        meaningList[2] = meaningInput3.getText().toString();
        meaningList[3] = meaningInput4.getText().toString();
        meaningList[4] = meaningInput5.getText().toString();
        exampleList[0] = exampleInput1.getText().toString();
        exampleList[1] = exampleInput2.getText().toString();
        exampleList[2] = exampleInput3.getText().toString();
        exampleList[3] = exampleInput4.getText().toString();
        exampleList[4] = exampleInput5.getText().toString();

        if (v.getId() == R.id.addButton) {

            if (
                    (wordList[0].equals("") || meaningList[0].equals("") || exampleList[0].equals(""))||
                    (wordList[1].equals("") || meaningList[1].equals("") || exampleList[1].equals(""))||
                    (wordList[2].equals("") || meaningList[2].equals("") || exampleList[2].equals(""))||
                    (wordList[3].equals("") || meaningList[3].equals("") || exampleList[3].equals(""))||
                    (wordList[4].equals("") || meaningList[4].equals("") || exampleList[4].equals(""))) {

                Toast.makeText(getApplicationContext(), "Please enter your Vocabulary", Toast.LENGTH_LONG).show();

            } else {

                     long rowId1 = myDataBaseHelper.insertDataToLearn(wordList[4],meaningList[4],exampleList[4]);
                     long rowId2 = myDataBaseHelper.insertDataToLearn(wordList[3],meaningList[3],exampleList[3]);
                     long rowId3 = myDataBaseHelper.insertDataToLearn(wordList[2],meaningList[2],exampleList[2]);
                     long rowId4 = myDataBaseHelper.insertDataToLearn(wordList[1],meaningList[1],exampleList[1]);
                     long rowId5 = myDataBaseHelper.insertDataToLearn(wordList[0],meaningList[0],exampleList[0]);
                     getRowId(rowId1,rowId2,rowId3,rowId4,rowId5);

                Intent intent = new Intent(GetVocabActivity.this, FlashCardActivity.class);
                intent.putExtra("word", wordList);
                intent.putExtra("meaning", meaningList);
                intent.putExtra("example", exampleList);
                startActivity(intent);
                finish();
                }


        }
    }


    /** *************************get row id methods****************/
    void getRowId(long rowId1, long rowId2, long rowId3, long rowId4, long rowId5){
        if(rowId1 == -1 || rowId2 == -1 || rowId3 == -1 || rowId4 == -1 || rowId5 == -1){
            Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_LONG).show();

        } else {
            wordInput1.setText("");
            meaningInput1.setText("");
            exampleInput1.setText("");
            wordInput2.setText("");
            meaningInput2.setText("");
            exampleInput2.setText("");
            wordInput3.setText("");
            meaningInput3.setText("");
            exampleInput3.setText("");
            wordInput4.setText("");
            meaningInput4.setText("");
            exampleInput4.setText("");
            wordInput5.setText("");
            meaningInput5.setText("");
            exampleInput5.setText("");
        }
    }


    void typeCast(){

        wordInput1 = this.findViewById(R.id.wordInput1);
        wordInput2 = this.findViewById(R.id.wordInput2);
        wordInput3 = this.findViewById(R.id.wordInput3);
        wordInput4 = this.findViewById(R.id.wordInput4);
        wordInput5 = this.findViewById(R.id.wordInput5);
        meaningInput1 = this.findViewById(R.id.meaningInput1);
        meaningInput2 = this.findViewById(R.id.meaningInput2);
        meaningInput3 = this.findViewById(R.id.meaningInput3);
        meaningInput4 = this.findViewById(R.id.meaningInput4);
        meaningInput5 = this.findViewById(R.id.meaningInput5);
        exampleInput1 = this.findViewById(R.id.exampleInput1);
        exampleInput2 = this.findViewById(R.id.exampleInput2);
        exampleInput3 = this.findViewById(R.id.exampleInput3);
        exampleInput4 = this.findViewById(R.id.exampleInput4);
        exampleInput5 = this.findViewById(R.id.exampleInput5);
        addButton = this.findViewById(R.id.addButton);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {

            Intent intent = new Intent();
            intent.putExtra("key","1");
            setResult(1,intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}