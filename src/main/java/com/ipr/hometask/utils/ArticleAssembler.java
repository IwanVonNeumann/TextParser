package com.ipr.hometask.utils;

import com.ipr.hometask.presentation.ParsedArticleResponse;
import com.ipr.hometask.presentation.WordsList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Iwan on 03.06.2015
 */

public class ArticleAssembler {

    public static ParsedArticleResponse getArticle(
            String header, List<String> text, Map<Integer, Set<String>> topSet) {

        ParsedArticleResponse article = new ParsedArticleResponse();

        article.setHeader(header);
        article.setText(text);

        List<WordsList> topWords = new ArrayList<>(topSet.size());

        for (Integer key : topSet.keySet()) {
            topWords.add(new WordsList(topSet.get(key), key));
        }

        article.setTopWords(topWords);

        return article;
    }
}
