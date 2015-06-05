package com.ipr.hometask.utils;

import com.ipr.hometask.presentation.ParsedArticleResponse;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;

/**
 * Created by Iwan on 03.06.2015
 */

// OK
public class ArticleAssemblerTest {

    @Test
    public void articleShouldContainGroupedWordsTopAndPreserveOrder() {

        String word1 = "word1";
        String word2 = "word2";
        String word3 = "word3";

        int k12 = 5;
        int k3 = 7;

        Set<String> set12 = new HashSet<>(Arrays.asList(word1, word2));
        Set<String> set3 = new HashSet<>(Collections.singletonList(word3));

        Map<Integer, Set<String>> topSet = new TreeMap<>();
        topSet.put(k12, set12);
        topSet.put(k3, set3);

        ParsedArticleResponse article = ArticleAssembler.getArticle(
                anyString(), anyListOf(String.class), topSet);

        assertEquals(2, article.getTopWords().size());
        assertEquals(k12, article.getTopWords().get(0).getCount().intValue());
        assertEquals(k3, article.getTopWords().get(1).getCount().intValue());

        assertTrue(article.getTopWords().get(0).getWords().contains(word1));
        assertTrue(article.getTopWords().get(0).getWords().contains(word2));
        assertFalse(article.getTopWords().get(0).getWords().contains(word3));

        assertFalse(article.getTopWords().get(1).getWords().contains(word1));
        assertFalse(article.getTopWords().get(1).getWords().contains(word2));
        assertTrue(article.getTopWords().get(1).getWords().contains(word3));
    }
}
