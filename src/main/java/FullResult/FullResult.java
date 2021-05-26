package FullResult;

import FullResult.SingleResult.SingleResult;
import org.decimal4j.util.DoubleRounder;

import java.util.ArrayList;
import java.util.HashSet;

public class FullResult {
    private ArrayList<SingleResult> results;
    private int total_key_letters_appearance;
    private int total_valid_letters;
    private double total_frequency;


    public FullResult(ArrayList<SingleResult> results, int total_key_letters_appearance, int total_valid_letters) {
        this.results = results;
        this.total_key_letters_appearance = total_key_letters_appearance;
        this.total_valid_letters = total_valid_letters;
    }

    public FullResult() {
        results = new ArrayList<>();
        total_key_letters_appearance = 0;
        total_valid_letters = 0;
    }

    public void addResult(HashSet<Character> included_letters, int word_length, int number_of_included_letters){
        this.total_key_letters_appearance += number_of_included_letters;
        this.total_valid_letters += word_length;
        for(SingleResult singleResult: results){
            if(singleResult.BelongsToTheGroup(included_letters, word_length)){
                singleResult.incrementNumberOfIncludedLetters(number_of_included_letters);
                return;
            }
        }
        results.add(new SingleResult(included_letters, word_length, number_of_included_letters));
    }

    public void CalculateFrequency(){
        for(SingleResult singleResult: results){
            singleResult.CalculateFrequency(total_key_letters_appearance);
        }
        total_frequency = DoubleRounder.round((double) total_key_letters_appearance/total_valid_letters, 2);
    }
}
