package com.gl.eugene.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.eugene.demo.exception.ResourceNotFoundException;
import com.gl.eugene.demo.model.Grade;
import com.gl.eugene.demo.model.Rating;
import com.gl.eugene.demo.service.RatingService;

@RestController
@RequestMapping("/")
public class RatingRestController implements InitializingBean {

    @Autowired
    private RatingService ratingService;

    @Override
    public void afterPropertiesSet() throws Exception {
        Rating rating = sampleRating();
        ratingService.saveRating(rating);
    }

    @GetMapping("/test")
    public ResponseEntity<Rating> test(String playerId) {
        return new ResponseEntity<Rating>(sampleRating(), HttpStatus.OK);
    }

    @GetMapping("/rating")
    public ResponseEntity<Rating> getRating(String playerId) {
        Optional<Rating> rating = ratingService.geRating(playerId);
        if (rating.isPresent()) {
            return new ResponseEntity<Rating>(rating.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Not found rating for player id: " + playerId);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Rating> updateRating(String playerId) {
        Optional<Rating> ratingOpt = ratingService.geRating(playerId);
        if (ratingOpt.isPresent()) {
            Rating rating = ratingOpt.get();
            rating.setWonGames(rating.getWonGames() + 1);
            return new ResponseEntity<Rating>(rating, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Not found rating for player id: " + playerId);
        }
    }

    private Rating sampleRating() {
        Rating rating = new Rating();
        rating.setId("1");
        rating.setGrade(Grade.GRAND_MASTER);
        rating.setTotalGames(1100);
        rating.setWonGames(1000);
        return rating;
    }

}
