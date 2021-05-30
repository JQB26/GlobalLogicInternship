package com.szczepanek.FrequencyCalc.FullResult;

import com.szczepanek.FrequencyCalc.FullResult.SingleResult.SingleResult;
import com.szczepanek.FrequencyCalc.Word.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FullResultTest {

    @Test
    void addResult() {
        HashSet<Character> included_letters1 = new HashSet<>();
        HashSet<Character> included_letters2 = new HashSet<>();

        included_letters1.add('a');
        included_letters1.add('b');
        included_letters1.add('c');

        included_letters2.add('a');
        included_letters2.add('b');

        Word word1 = new Word(included_letters1, 10, 5);
        Word word2 = new Word(included_letters2, 10, 5);

        FullResult fullResult = new FullResult();
        fullResult.addResult(word1);

        Assertions.assertTrue(fullResult.getResults().get(0).BelongsToTheGroup(word1));
        Assertions.assertFalse(fullResult.getResults().get(0).BelongsToTheGroup(word2));

        fullResult.addResult(word2);

        Assertions.assertTrue(fullResult.getResults().get(1).BelongsToTheGroup(word2));

    }

    @Test
    void calculateFrequency() {
        Word word1 = new Word(new HashSet<>(), 10, 5);
        Word word2 = new Word(new HashSet<>(), 13, 7);

        FullResult fullResult = new FullResult();
        fullResult.addResult(word1);
        fullResult.addResult(word2);

        fullResult.CalculateFrequency();

        double expected1 = 0.42;
        double expected2 = 0.58;
        double expected3 = 0.52;

        Assertions.assertEquals(expected1, fullResult.getResults().get(0).getFrequency());
        Assertions.assertEquals(expected2, fullResult.getResults().get(1).getFrequency());
        Assertions.assertEquals(expected3, fullResult.getTotal_frequency());
    }
}