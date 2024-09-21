package com.gl.eugene.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.eugene.demo.rest.dto.RatingDto;
import com.gl.eugene.demo.rest.service.RatingRestService;

@RestController
@RequestMapping("/")
public class RatingRestController {

    public RatingRestService ratingService;
    public ObjectMapper objectMapper;

    public RatingRestController(RatingRestService ratingService, ObjectMapper objectMapper) {
        this.ratingService = ratingService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/rating")
    public ResponseEntity<RatingDto> getRating(String playerId) {
        Optional<RatingDto> ratingOptional = ratingService.getRating(playerId);
        return new ResponseEntity<RatingDto>(ratingOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<RatingDto> updateRating(@RequestBody RatingDto newRating) {
        Optional<RatingDto> updateRating = Optional.empty();
        try {
            updateRating = ratingService.updateRating(newRating);
        } catch (Exception e) {
            System.err.println(e);
        }
        return new ResponseEntity<RatingDto>(updateRating.get(), HttpStatus.OK);
    }

}
