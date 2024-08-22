package com.gl.eugene.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.gl.eugene.demo.service.RatingService;

@Configuration
public class AppConfig {

    @Autowired
    public RatingService ratingService;

}
