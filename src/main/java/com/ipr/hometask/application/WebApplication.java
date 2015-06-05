package com.ipr.hometask.application;

import com.ipr.hometask.config.SpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Iwan on 01.06.2015
 */

public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfiguration.class, args);
    }
}
