package com.ipr.hometask.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Iwan on 01.06.2015
 */

public class TextParser {

    public static final String WORD_PATTERN = "\\w+";
    public static final Pattern PATTERN = Pattern.compile(WORD_PATTERN);

    public static Map<String, Integer> parseStrings(List<String> stringList) {

        Map<String, Integer> dictionary = new HashMap<>();

        for (String line : stringList) {
            Matcher matcher = PATTERN.matcher(line);
            while (matcher.find()) {
                String word = matcher.group().toLowerCase();
                Integer count = dictionary.put(word, 1);
                if (count != null) {
                    dictionary.put(word, count + 1);
                }
            }
        }
        return dictionary;
    }
}
