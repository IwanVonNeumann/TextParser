package com.ipr.hometask.out;

import com.ipr.hometask.utils.WordsFormatter;
import org.apache.log4j.Logger;

import java.util.Formatter;
import java.util.Map;
import java.util.Set;

/**
 * Created by Iwan on 02.06.2015
 */

public class ListPrinter {

    private final static Logger log = Logger.getLogger(ListPrinter.class);


    public static void printFrequentWords(Map<Integer, Set<String>> top, int k) {

        log.info("Top " + k + " words:");

        int i = 1;
        for (Integer key : top.keySet()) {
            Set<String> words = top.get(key);
            Formatter formatter = new Formatter();
            formatter.format("%d. %s - %d", i++, WordsFormatter.formatWords(words), key);
            log.info(formatter.toString());
        }
    }
}
