package com.szczepanek.FrequencyCalc.FullResult;

import com.szczepanek.FrequencyCalc.FullResult.SingleResult.SingleResult;
import com.szczepanek.FrequencyCalc.Word.Word;
import org.decimal4j.util.DoubleRounder;

import java.util.ArrayList;
import java.util.Comparator;

public class FullResult {
    private final ArrayList<SingleResult> results;
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

    // adds a word to the results, increments necessary variables
    public void addResult(Word word) {
        this.total_key_letters_appearance += word.getNumber_of_included_letters();
        this.total_valid_letters += word.getWord_length();
        for (SingleResult singleResult : results) {
            if (singleResult.BelongsToTheGroup(word)) {
                singleResult.incrementNumberOfIncludedLetters(word.getNumber_of_included_letters());
                return;
            }
        }
        results.add(new SingleResult(word));
    }

    // calculates frequency for each result and total_frequency
    public void CalculateFrequency() {
        for (SingleResult singleResult : results) {
            singleResult.CalculateFrequency(total_key_letters_appearance);
        }
        total_frequency = DoubleRounder.round((double) total_key_letters_appearance / total_valid_letters, 2);
    }

    // sorts results by frequency and word length
    public void sort() {
        results.sort(Comparator.comparing(SingleResult::getFrequency).thenComparing(SingleResult::getWord_length));
    }

    public void print() {
        if (results.isEmpty()) {
            System.out.println("No results");
        } else {
            for (SingleResult singleResult : results) {
                singleResult.print(total_key_letters_appearance);
            }
            System.out.println("TOTAL Frequency: " + total_frequency + " (" + total_key_letters_appearance +
                    "/" + total_valid_letters + ")");
        }
    }

    public ArrayList<SingleResult> getResults() {
        return results;
    }

    public double getTotal_frequency() {
        return total_frequency;
    }
}
