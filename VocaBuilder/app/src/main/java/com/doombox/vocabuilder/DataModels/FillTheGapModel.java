package com.doombox.vocabuilder.DataModels;

public class FillTheGapModel {

    String question, word;

    public FillTheGapModel(String question, String word) {
        this.question = question;
        this.word = word;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
