package com.gl.eugene.demo.rest.service;

import java.util.Optional;

import com.gl.eugene.demo.rest.dto.RatingDto;
import com.gl.eugene.demo.rest.exception.RestEntityNotFoundException;

public interface RatingRestServiceIfc {

    void createRating(RatingDto newRating);

    Optional<RatingDto> getRating(String playerId) throws RestEntityNotFoundException;

    Optional<RatingDto> updateRating(RatingDto newRating) throws RestEntityNotFoundException;

}
