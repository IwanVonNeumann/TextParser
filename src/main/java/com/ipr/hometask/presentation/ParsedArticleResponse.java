package com.ipr.hometask.presentation;

import java.util.List;

/**
 * Created by Iwan on 02.06.2015
 */

public class ParsedArticleResponse {

    private String header;
    private List<String> text;
    private List<WordsList> topWords;

    private boolean successful;
    private String message;


    public ParsedArticleResponse() {
    }


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public List<WordsList> getTopWords() {
        return topWords;
    }

    public void setTopWords(List<WordsList> topWords) {
        this.topWords = topWords;
    }


    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
