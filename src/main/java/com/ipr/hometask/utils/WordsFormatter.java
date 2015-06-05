package com.ipr.hometask.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * Created by Iwan on 02.06.2015
 */

public class WordsFormatter {

    public static final String APOSTROPHE = "'";
    public static final String WORD_SEPARATOR = ", ";

    public static String formatWords(Set<String> wordsSet) {

        if (!CollectionUtils.isEmpty(wordsSet)) {
            return APOSTROPHE +
                    StringUtils.join(wordsSet,
                            StringUtils.wrap(WORD_SEPARATOR, APOSTROPHE)) +
                    APOSTROPHE;
        }

        return "";
    }
}
