package com.ipr.hometask.utils;

/**
 * Created by Iwan on 03.06.2015
 */

public class FileProcessingResult {

    private boolean successful;
    private String message;


    public FileProcessingResult() {
    }

    public FileProcessingResult(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
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
