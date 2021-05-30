package com.szczepanek.FrequencyCalc.FullResult.SingleResult;

import com.szczepanek.FrequencyCalc.Word.Word;
import org.decimal4j.util.DoubleRounder;


public class SingleResult extends Word {
    private double frequency;

    public SingleResult(Word word){
        super(word.getIncluded_letters(), word.getWord_length(), word.getNumber_of_included_letters());
    }

    public SingleResult() {
        super();
    }

    // checks if included letters and word length are the same
    public boolean BelongsToTheGroup(Word word){
        return word.getIncluded_letters().equals(this.included_letters) && word.getWord_length() == this.word_length;
    }

    // calculates frequency and rounds result to two decimal places
    public void CalculateFrequency(int total_key_letters_appearance){
        frequency = DoubleRounder.round((double) number_of_included_letters/total_key_letters_appearance, 2);
    }

    public void print(int total_key_letters_appearance){
        System.out.println("{" + included_letters + ", " + word_length + "} = " + frequency + " (" +
                number_of_included_letters + "/" + total_key_letters_appearance + ")");
    }


    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
