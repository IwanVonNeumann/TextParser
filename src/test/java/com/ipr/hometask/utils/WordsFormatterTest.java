package com.ipr.hometask.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Iwan on 03.06.2015
 */

public class WordsFormatterTest {

    @Test
    public void emptySetShouldBeConvertedToEmptyString() {

        String actual = WordsFormatter.formatWords(Collections.EMPTY_SET);
        assertEquals("", actual);
    }

    @Test
    public void singleWordShouldKeepSame() {

        String word = "word";
        Set<String> oneStringSet = new HashSet<>(Collections.singletonList(word));

        String actual = WordsFormatter.formatWords(oneStringSet);

        assertEquals(StringUtils.wrap(word, WordsFormatter.APOSTROPHE), actual);
    }

    @Test
    //public void twoWordsShouldBeSeparatedByComma() {
    public void formatWords_ShouldReturnWordsSeparatedByComma() {

        Set<String> stringSet = new HashSet<>();////////////////
        String word1 = "word1";
        String word2 = "word2";
        stringSet.add(word1);
        stringSet.add(word2);

        String result = WordsFormatter.formatWords(stringSet);

        assertEquals(
                StringUtils.wrap(word1, WordsFormatter.APOSTROPHE) + WordsFormatter.WORD_SEPARATOR +
                        StringUtils.wrap(word2, WordsFormatter.APOSTROPHE),
                result);
    }
}
