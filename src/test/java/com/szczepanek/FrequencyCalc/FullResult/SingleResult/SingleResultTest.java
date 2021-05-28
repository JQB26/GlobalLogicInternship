package com.szczepanek.FrequencyCalc.FullResult.SingleResult;


import com.szczepanek.FrequencyCalc.Word.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class SingleResultTest {

    @Test
    void belongsToTheGroup() {
        HashSet<Character> included_letters1 = new HashSet<>();
        HashSet<Character> included_letters2 = new HashSet<>();

        included_letters1.add('a');
        included_letters1.add('b');
        included_letters1.add('c');

        included_letters2.add('a');
        included_letters2.add('b');

        SingleResult result1 = new SingleResult(new Word(included_letters1, 10, 5));
        SingleResult result2 = new SingleResult(new Word(included_letters2, 10, 5));

        Assertions.assertFalse(result1.BelongsToTheGroup(result2));

        result2.addIncludedLetter('c');

        Assertions.assertTrue(result1.BelongsToTheGroup(result2));
    }

    @Test
    void calculateFrequency() {
        SingleResult result = new SingleResult(new Word(new HashSet<Character>(), 0, 5));
        double expected1 = 0.71;
        double expected2 = 0.42;

        result.CalculateFrequency(7);
        Assertions.assertEquals(expected1, result.getFrequency());

        result.CalculateFrequency(12);
        Assertions.assertEquals(expected2, result.getFrequency());
    }
}