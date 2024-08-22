package com.gl.eugene.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.eugene.demo.jpa.entity.Rating;
import com.gl.eugene.demo.model.Grade;

@RestController
@RequestMapping("/")
public class RatingRestController {

    @GetMapping("/rating")
    public Rating getRating(String playerId) {
        Rating rating = new Rating();
        rating.setId("1");
        rating.setGrade(Grade.GRAND_MASTER);
        rating.setTotalGames(1100);
        rating.setWonGames(1000);
        return rating;
    }

    @GetMapping("/rating2")
    public String getRating() {
        return "654asda46s5d_AS d--a s-d -as";
    }

}
