package com.ipr.hometask.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Iwan on 03.06.2015
 */

public class MapFilterTest {

    @Test
    public void topShouldIncludeMostFrequentWords() {

        Map<String, Integer> dictionary = new HashMap<>();

        String word1 = "word1";
        String word2 = "word2";
        String word3 = "word3";

        int k1 = 3;
        int k2 = 5;
        int k3 = 7;

        dictionary.put(word1, k1);
        dictionary.put(word2, k2);
        dictionary.put(word3, k3);

        Map<Integer, Set<String>> frequentWords = MapFilter.getTop(dictionary, 2);

        assertEquals(2, frequentWords.size());

        assertNull(frequentWords.get(k1));

        assertEquals(1, frequentWords.get(k2).size());
        assertEquals(1, frequentWords.get(k3).size());

        assertTrue(frequentWords.get(k2).contains(word2));
        assertTrue(frequentWords.get(k3).contains(word3));
    }


    @Test
    public void equallyFrequentWordsShouldBeGrouped() {

        Map<String, Integer> dictionary = new HashMap<>();

        String word1 = "word1";
        String word2 = "word2";
        String word3 = "word3";

        int k12 = 5;
        int k3 = 7;

        dictionary.put(word1, k12);
        dictionary.put(word2, k12);
        dictionary.put(word3, k3);

        Map<Integer, Set<String>> groupedWords = MapFilter.groupWords(dictionary);

        assertEquals(2, groupedWords.size());
        assertEquals(2, groupedWords.get(k12).size());
        assertEquals(1, groupedWords.get(k3).size());

        assertTrue(groupedWords.get(k12).contains(word1));
        assertTrue(groupedWords.get(k12).contains(word2));
        assertTrue(groupedWords.get(k3).contains(word3));
    }
}
