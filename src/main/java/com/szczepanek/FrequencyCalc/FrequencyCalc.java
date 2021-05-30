package com.szczepanek.FrequencyCalc;

import com.google.gson.Gson;
import com.szczepanek.FrequencyCalc.FullResult.FullResult;
import com.szczepanek.FrequencyCalc.Input.Input;
import com.szczepanek.FrequencyCalc.Word.Word;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class FrequencyCalc {
    private final Input input;
    private final HashSet<Character> key;
    FullResult result;

    private final String filePath;

    public FrequencyCalc(Input input) {
        this.input = input;
        key = new HashSet<>();
        result = new FullResult();

        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        filePath = "src/main/resources/GeneratedData/" + dateFormat.format(date) + ".json";
    }

    public FrequencyCalc() {
        input = new Input();
        key = new HashSet<>();
        result = new FullResult();

        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        filePath = "src/main/resources/GeneratedData/" + dateFormat.format(date) + ".json";
    }

    public void print(){
        result.print();
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
                    result.addResult(word);
                }
                word = new Word();
            }
        }
        //last word push
        if(!word.isEmpty()){
            result.addResult(word);
        }

        result.CalculateFrequency();
        result.sort();
    }

    public void SaveToFile(){
        try(FileWriter fr = new FileWriter(filePath)){
            Gson gson = new Gson();
            fr.write(gson.toJson(result));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // change the Key from String to HashSet
    private void InterpretTheKey(){
        for(int i = 0; i < input.getKey().length(); i++){
            key.add(input.getKey().charAt(i));
        }
    }

    // set both key and input to be lowerCase
    private void SetStringsToLowerCase(){
        input.setKey(input.getKey().toLowerCase(Locale.ROOT));
        input.setInput(input.getInput().toLowerCase(Locale.ROOT));
    }

    public void GetInputFromCommandLine(){
        input.readFromCommandLine();
    }


}
