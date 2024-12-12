package com.doombox.vocabuilder;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "VocaBuilder.db";
    private static final String TABLE_NAME_TO_LEARN = "ToLearnWordList";
    private static final String TABLE_NAME_LEARNED = "LearnedWordList";
    private static final String ID = "_id";
    private static final String WORD = "Word";
    private static final String MEANING = "Meaning";
    private static final String EXAMPLE = "Example";

    private static final int VERSION = 1;

    private final Context context;
    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE "+ TABLE_NAME_TO_LEARN +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ WORD +" TEXT, "+ MEANING +" TEXT, "+ EXAMPLE +" TEXT)");

            db.execSQL("CREATE TABLE "+ TABLE_NAME_LEARNED +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ WORD +" TEXT, "+ MEANING +" TEXT, "+ EXAMPLE +" TEXT)");
        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

 
        try {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_TO_LEARN);
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_LEARNED);
            onCreate(db);

        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_LONG).show();
        }

    }

    /************* Methods for TO LEARN VOCAB LIST   ******************* */
    public long insertDataToLearn(String word, String meaning, String example){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WORD,word);
        contentValues.put(MEANING,meaning);
        contentValues.put(EXAMPLE,example);


        return db.insert(TABLE_NAME_TO_LEARN,null,contentValues);

    }

    public Cursor displayAllDataToLearn(){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME_TO_LEARN + " ORDER BY " + ID + " DESC", null);
    }

    void updateDataToLearn(String id, String word, String meaning, String example){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(WORD, word);
        cv.put(MEANING, meaning);
        cv.put(EXAMPLE, example);

        long result = db.update(TABLE_NAME_TO_LEARN, cv, ID+"=?", new String[]{id});
        if(result == -1){
             Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
             Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
    }

}


    public void deleteOneRowToLearn(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_TO_LEARN, ID+"=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }



    }

    public int getCountToLearn(){
        String query = "SELECT * FROM " +TABLE_NAME_TO_LEARN;
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);

        return cursor.getCount();

    }

    /************* Methods for TO LEARN VOCAB LIST   ******************* */
    public Cursor displayAllDataLearned(){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM "+ TABLE_NAME_LEARNED +" ORDER BY "+ ID +" DESC",null);
    }

    public void insertDataLearned(String word, String meaning, String example){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WORD,word);
        contentValues.put(MEANING,meaning);
        contentValues.put(EXAMPLE,example);


        db.insert(TABLE_NAME_LEARNED, null, contentValues);
    }

    void updateDataLearned(String id, String word, String meaning, String example){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(WORD, word);
        cv.put(MEANING, meaning);
        cv.put(EXAMPLE, example);

        long result = db.update(TABLE_NAME_LEARNED, cv, ID+"=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteOneRowLearned(String row_id){

        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_LEARNED, ID+"=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }
    }

    public int getCountLearned(){
        String query = "SELECT * FROM " +TABLE_NAME_LEARNED;
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);

        return cursor.getCount();
    }

}
