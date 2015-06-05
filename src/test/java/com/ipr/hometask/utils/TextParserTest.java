package com.ipr.hometask.utils;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Iwan on 03.06.2015
 */

// OK
public class TextParserTest {

    @Test
    public void oneWordShouldBeCountedOnce() {

        String word = "word";
        List<String> stringList = Collections.singletonList(word);

        Map<String, Integer> parsedString = TextParser.parseStrings(stringList);

        assertEquals(1, parsedString.size());
        assertEquals(1, parsedString.get(word).intValue());
    }

    @Test
    public void spacesShouldSeparateWords() {

        String word = "word";
        List<String> stringList = Collections.singletonList(word + " " + word);

        Map<String, Integer> parsedString = TextParser.parseStrings(stringList);

        assertEquals(1, parsedString.size());
        assertEquals(2, parsedString.get(word).intValue());
    }

    @Test
    public void sentenceBeginningShouldBeIgnored() {

        String word = "word";
        List<String> stringList = Collections.singletonList(
                word + " " + StringUtils.capitalize(word));

        Map<String, Integer> parsedString = TextParser.parseStrings(stringList);

        assertEquals(1, parsedString.size());
        assertEquals(2, parsedString.get(word).intValue());
    }

    @Test
    public void punctuationShouldBeEscaped() {

        String word = "word";
        List<String> stringList = Collections.singletonList(word + ".,!?'\"" + word);

        Map<String, Integer> parsedString = TextParser.parseStrings(stringList);

        assertEquals(1, parsedString.size());
        assertEquals(2, parsedString.get(word).intValue());
    }

    @Test
    public void wordsShouldBeCountedInDifferentLines() {

        String word = "word";
        List<String> stringList = Arrays.asList(word, word);

        Map<String, Integer> parsedString = TextParser.parseStrings(stringList);

        assertEquals(1, parsedString.size());
        assertEquals(2, parsedString.get(word).intValue());
    }

    @Test
    public void differentWordsShouldBeCountedSeparately() {

        String word1 = "word1";
        String word2 = "word2";
        List<String> stringList = Arrays.asList(word1, word2);

        Map<String, Integer> parsedString = TextParser.parseStrings(stringList);

        assertEquals(2, parsedString.size());
        assertEquals(1, parsedString.get(word1).intValue());
        assertEquals(1, parsedString.get(word2).intValue());
    }
}
