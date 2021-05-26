package SingleResult;

import Word.Word;

import java.util.HashSet;

public class SingleResult extends Word {
    private double frequency;

    public SingleResult(HashSet<Character> included_letters, int word_length, int number_of_included_letters) {
        super(included_letters, word_length, number_of_included_letters);
    }

    public boolean BelongsToTheGroup(HashSet<Character> included_letters, int word_length){
        return included_letters.equals(this.included_letters) && word_length == this.word_length;
    }


    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
