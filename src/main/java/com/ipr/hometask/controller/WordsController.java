package com.ipr.hometask.controller;

import com.ipr.hometask.files.FileUtils;
import com.ipr.hometask.presentation.ParsedArticleResponse;
import com.ipr.hometask.utils.ArticleAssembler;
import com.ipr.hometask.utils.FileProcessingResult;
import com.ipr.hometask.utils.MapFilter;
import com.ipr.hometask.utils.TextParser;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Iwan on 01.06.2015
 */

@Controller
public class WordsController {

    private final Logger log = Logger.getLogger(WordsController.class);

    public static final int TOP_SIZE = 10;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }


    @RequestMapping(value = "/text", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ParsedArticleResponse loadDataFromFile(@RequestParam("file") MultipartFile file) {

        String name = file.getOriginalFilename();
        log.info("File received: " + name);

        FileProcessingResult processingResult = FileUtils.checkFile(file);
        ParsedArticleResponse article;

        if (processingResult.isSuccessful()) {
            List<String> text = FileUtils.multipartFileToStringList(file);
            Map<String, Integer> dictionary = TextParser.parseStrings(text);
            Map<Integer, Set<String>> topSet = MapFilter.getTop(dictionary, TOP_SIZE);

            article = ArticleAssembler.getArticle(name, text, topSet);
        } else {
            article = new ParsedArticleResponse();
        }

        article.setSuccessful(processingResult.isSuccessful());
        article.setMessage(processingResult.getMessage());

        return article;
    }
}
