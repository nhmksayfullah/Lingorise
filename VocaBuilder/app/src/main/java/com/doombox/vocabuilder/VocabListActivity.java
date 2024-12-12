package com.doombox.vocabuilder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.doombox.vocabuilder.Adapters.AdapterVocabList;
import com.doombox.vocabuilder.DataModels.VocabListModel;
import java.util.ArrayList;
import java.util.List;

public class VocabListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    View actionBar;
    ImageView startActionBtn, closeActionBtn;
    TextView counterTxt, emptyTxt;

    public Boolean is_in_action_mode = false;
    List<VocabListModel> selectionList = new ArrayList<>();
    public int counter = 0;

    String[] words = new String[5];
    String[] meanings = new String[5];
    String[] examples = new String[5];


    ArrayList<String> idList = new ArrayList<>();
    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> meaningList = new ArrayList<>();
    ArrayList<String> exampleList = new ArrayList<>();

    List<VocabListModel> vocabList = new ArrayList<>();

    MyDataBaseHelper myDataBaseHelper;
    AdapterVocabList adapter;

    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocablist);



        recyclerView = findViewById(R.id.vocabListId);
        actionBar = findViewById(R.id.actionBarId);
        startActionBtn = findViewById(R.id.startActionBtnId);
        closeActionBtn = findViewById(R.id.closeActionBtnId);
        counterTxt = findViewById(R.id.counterTxtId);
        emptyTxt = findViewById(R.id.emptyTxtId);
        actionBar.setVisibility(View.GONE);

        myDataBaseHelper = new MyDataBaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            tableName = bundle.getString("table");
            displayData(tableName);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        closeActionBtn.setOnClickListener(v -> {
            clearActionMode();
            adapter.notifyDataSetChanged();
        });

        startActionBtn.setOnClickListener(v -> {

            if (!is_in_action_mode){

                actionBar.setVisibility(View.VISIBLE);
                is_in_action_mode = true;
                adapter.notifyDataSetChanged();

            } else {

                if (counter<5){

                    Toast.makeText(getApplicationContext(), "Select at least 5 words ", Toast.LENGTH_SHORT).show();

                } else {


                    listToArray();
                    clearActionMode();
                    adapter.notifyDataSetChanged();

                    Intent intent = new Intent(getApplicationContext(),FlashCardActivity.class);
                    intent.putExtra("word", words);
                    intent.putExtra("meaning", meanings);
                    intent.putExtra("example", examples);
                    startActivity(intent);
                    finish();

                }

            }

        });



    }


    /**
     *
     * @param tableName tableName come by intent. by the count, show data from different table
     */
    public void displayData(String tableName){

        if (tableName.equals("1")){
            loadDataForToLearn();

        } else if (tableName.equals("2")){
            loadDataForLearned();
        }
    }

    /**
     * get and show data for toLearnVocabList table
     */
    public void loadDataForToLearn(){



        Cursor cursor = myDataBaseHelper.displayAllDataToLearn();
        if (cursor.getCount() == 0){
            emptyTxt.setVisibility(View.VISIBLE);
            startActionBtn.setVisibility(View.GONE);
        } else {
            while (cursor.moveToNext()){
                idList.add(cursor.getString(0));
                wordList.add(cursor.getString(1));
                meaningList.add(cursor.getString(2));
                exampleList.add(cursor.getString(3));
            }


            for (int i = 0 ; i<idList.size() ; i++){

                vocabList.add(new VocabListModel(idList.get(i),wordList.get(i),meaningList.get(i),exampleList.get(i),tableName));

            }
            adapter = new AdapterVocabList(this,this,vocabList);


        }

    }

    /**
     * get and show data for learnedVocabList table
     */
    public void loadDataForLearned(){

        Cursor cursor = myDataBaseHelper.displayAllDataLearned();
        if (cursor.getCount() == 0){
            emptyTxt.setVisibility(View.VISIBLE);
            startActionBtn.setVisibility(View.GONE);
        } else {
            while (cursor.moveToNext()){
                idList.add(cursor.getString(0));
                wordList.add(cursor.getString(1));
                meaningList.add(cursor.getString(2));
                exampleList.add(cursor.getString(3));
            }

            for (int i = 0 ; i<idList.size() ; i++){

                vocabList.add(new VocabListModel(idList.get(i),wordList.get(i),meaningList.get(i),exampleList.get(i),tableName));

            }

            adapter = new AdapterVocabList(this,this,vocabList);


        }

    }


    public void clickSelected(int position){

        counter = counter+1;

        if (counter>5){

            Toast.makeText(this, "You can not get more then 5 words", Toast.LENGTH_SHORT).show();
        } else {

            selectionList.add(vocabList.get(position));
            updateCounter(counter);
        }




    }
    public void clickDeSelected(int position){

        selectionList.remove(vocabList.get(position));
        counter = counter-1;
        updateCounter(counter);


    }



    public void listToArray(){

        for (int position = 0 ; position<5 ; position++){

            VocabListModel vocabListModel = selectionList.get(position);
            words[position] = vocabListModel.getWord();
            meanings[position] = vocabListModel.getMeaning();
            examples[position] = vocabListModel.getExample();
        }



    }


    @SuppressLint("SetTextI18n")
    public void updateCounter(int counter){

        if (counter==0){
            counterTxt.setText("0 selected");
        } else  counterTxt.setText(counter + " selected");
    }


    @SuppressLint("SetTextI18n")
    public void clearActionMode(){

        is_in_action_mode = false;
        actionBar.setVisibility(View.GONE);
        counterTxt.setText("0 selected");
        counter = 0;
        selectionList.clear();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }


    @Override
    public void onBackPressed() {

        if (is_in_action_mode){
            clearActionMode();
            adapter.notifyDataSetChanged();
        } else {

            Intent intent = new Intent();
            intent.putExtra("key","1");
            setResult(1,intent);
            finish();
            super.onBackPressed();
        }

    }

}