package com.ipr.hometask.presentation;

import java.util.Set;

/**
 * Created by Iwan on 02.06.2015
 */

public class WordsList {

    private Set<String> words;
    private Integer count;


    public WordsList() {
    }

    public WordsList(Set<String> words, Integer count) {
        this.words = words;
        this.count = count;
    }


    public Set<String> getWords() {
        return words;
    }

    public void setWords(Set<String> words) {
        this.words = words;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "WordsList{" +
                "words=" + words +
                ", count=" + count +
                '}';
    }
}
