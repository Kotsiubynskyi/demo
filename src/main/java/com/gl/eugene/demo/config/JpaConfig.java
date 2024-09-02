package com.gl.eugene.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.gl.eugene.demo.jpa.repository.RatingRepository;

@Configuration
public class JpaConfig {

    @Autowired
    private RatingRepository ratingRepository;

}
