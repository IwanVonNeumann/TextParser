package com.ipr.hometask.files;

import com.ipr.hometask.utils.FileProcessingResult;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Iwan on 01.06.2015
 */

public class FileUtils {

    private final static Logger log = Logger.getLogger(FileUtils.class);

    public static final String LINE_BREAK_PATTERN = "\\r?\\n";

    public static final String EMPTY_FILE_ERROR_MESSAGE = "Processing error: file is empty!";
    public static final String EXTENSION_ERROR_MESSAGE = "Processing error: file is non-text!";
    public static final String SUCCESSFUL_PROCESSING_MESSAGE = "File processed successfully.";

    public static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(
            Arrays.asList("txt"));


    public static List<String> fileToStringList(String url) {
        try {
            return Files.readAllLines(Paths.get(url), Charset.defaultCharset());
        } catch (IOException e) {
            log.error("IOException when reading file", e);
            return Collections.emptyList();
        }
    }


    public static List<String> multipartFileToStringList(MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String string = new String(bytes);
                return Arrays.asList(string.split(LINE_BREAK_PATTERN));
            } catch (IOException e) {
                log.info("IOException when reading multipart file", e);
            }
        }
        return Collections.emptyList();
    }


    public static FileProcessingResult checkFile(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        log.info("Checking file " + fileName);

        if (file.isEmpty()) {
            log.error("File is empty");
            return new FileProcessingResult(false, EMPTY_FILE_ERROR_MESSAGE);
        }

        if (!ALLOWED_EXTENSIONS.contains(FilenameUtils.getExtension(fileName))) {
            log.error("File is non-text");
            return new FileProcessingResult(false, EXTENSION_ERROR_MESSAGE);
        }

        log.info("File processed successfully");
        return new FileProcessingResult(true, SUCCESSFUL_PROCESSING_MESSAGE);
    }
}
