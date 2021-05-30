package com.szczepanek.FrequencyCalc.Word;

import java.util.HashSet;

public class Word {
    protected HashSet<Character> included_letters;
    protected int word_length;
    protected int number_of_included_letters;

    public Word(HashSet<Character> included_letters, int word_length, int number_of_included_letters) {
        this.included_letters = included_letters;
        this.word_length = word_length;
        this.number_of_included_letters = number_of_included_letters;
    }

    public Word() {
        included_letters = new HashSet<>();
        word_length = 0;
        number_of_included_letters = 0;
    }

    public void addIncludedLetter(Character letter) {
        included_letters.add(letter);
    }

    public void incrementWordLength() {
        word_length++;
    }

    public void incrementNumberOfIncludedLetters() {
        number_of_included_letters++;
    }

    public void incrementNumberOfIncludedLetters(int number_of_included_letters) {
        this.number_of_included_letters += number_of_included_letters;
    }

    // returns true if no included letters are in the word
    public boolean isEmpty() {
        return number_of_included_letters == 0;
    }


    public HashSet<Character> getIncluded_letters() {
        return included_letters;
    }

    public void setIncluded_letters(HashSet<Character> included_letters) {
        this.included_letters = included_letters;
    }

    public int getWord_length() {
        return word_length;
    }

    public void setWord_length(int word_length) {
        this.word_length = word_length;
    }

    public int getNumber_of_included_letters() {
        return number_of_included_letters;
    }

    public void setNumber_of_included_letters(int number_of_included_letters) {
        this.number_of_included_letters = number_of_included_letters;
    }
}
