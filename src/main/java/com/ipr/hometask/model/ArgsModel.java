package com.ipr.hometask.model;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;
import com.ipr.hometask.validation.TextFileValidator;

import java.io.File;
import java.util.List;

/**
 * Created by Iwan on 04.06.2015
 */

public class ArgsModel {

    @Parameter(
            validateWith = TextFileValidator.class,
            required = true,
            description = "Text file location")
    private List<String> fileList;

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    @Override
    public String toString() {
        return "ArgsModel{" +
                "fileList=" + fileList +
                '}';
    }
}
