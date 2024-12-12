package com.doombox.vocabuilder.DataModels;

public class VocabListModel {

    private String id;
    private String word;
    private String meaning;
    private String example;
    private String tableId;

    public VocabListModel(String id, String word, String meaning, String example, String tableId) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.example = example;
        this.tableId = tableId;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
