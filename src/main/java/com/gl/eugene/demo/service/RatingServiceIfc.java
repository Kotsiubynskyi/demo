package com.gl.eugene.demo.service;

import java.util.Optional;

import com.gl.eugene.demo.model.Rating;

public interface RatingServiceIfc {

    void createRating(Rating newRating);

    Optional<Rating> geRating(String playerId);

    Optional<Rating> updateRating(Rating rating);

}
