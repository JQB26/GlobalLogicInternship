package com.szczepanek.FrequencyCalc;

import com.szczepanek.FrequencyCalc.FullResult.FullResult;
import com.szczepanek.FrequencyCalc.Input.Input;
import com.szczepanek.FrequencyCalc.Word.Word;

import java.util.HashSet;
import java.util.Locale;

public class FrequencyCalc {
    private final Input input;
    private final HashSet<Character> key;
    FullResult results;

    public FrequencyCalc(Input input) {
        this.input = input;
        key = new HashSet<>();
        results = new FullResult();
    }

    public FrequencyCalc() {
        input = new Input();
        key = new HashSet<>();
        results = new FullResult();
    }

    public void print(){
        results.print();
    }

    // main function in the application
    public void Calculate(){
        SetStringsToLowerCase();
        InterpretTheKey();

        Word word = new Word();
        // iterates through every char in the input
        for(int i = 0; i < input.getInput().length(); i++){
            char x = input.getInput().charAt(i);
            // checks if the char is a letter
            if(x >= 97 && x <= 122){
                word.incrementWordLength();
                // checks if letter is in the key
                if(key.contains(x)){
                    word.addIncludedLetter(x);
                    word.incrementNumberOfIncludedLetters();
                }
            }
            // if char is not a letter we "end" a word
            else{
                // if the word should be included in the result we add it
                if(!word.isEmpty()){
                    results.addResult(word);
                }
                word = new Word();
            }
        }
        //last word push
        if(!word.isEmpty()){
            results.addResult(word);
        }

        results.CalculateFrequency();
        results.sort();
    }


    // change the Key from String to HashSet
    public void InterpretTheKey(){
        for(int i = 0; i < input.getKey().length(); i++){
            key.add(input.getKey().charAt(i));
        }
    }

    // set both key and input to be lowerCase
    public void SetStringsToLowerCase(){
        input.setKey(input.getKey().toLowerCase(Locale.ROOT));
        input.setInput(input.getInput().toLowerCase(Locale.ROOT));
    }

    public void GetInputFromCommandLine(){
        input.readFromCommandLine();
    }


}
