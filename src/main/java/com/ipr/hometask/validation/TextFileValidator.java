package com.ipr.hometask.validation;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * Created by Iwan on 04.06.2015
 */

public class TextFileValidator implements IParameterValidator {

    public static final String TEXT_FILE_EXTENSION = "txt";

    @Override
    public void validate(String name, String value) throws ParameterException {
        File file = new File(value);
        if (!file.isFile() || !TEXT_FILE_EXTENSION.equals(FilenameUtils.getExtension(value))) {
            throw new ParameterException(value + " isn't a *.txt file or doesn't exist!");
        }
    }
}
