package model;

public class Word {
    private int wordId;
    private String word,meaning;

    public Word(int wordId, String word, String meaning) {


        this.wordId = wordId;
        this.word = word;
        this.meaning = meaning;
    }


    public int getWordId() {
        return wordId;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
