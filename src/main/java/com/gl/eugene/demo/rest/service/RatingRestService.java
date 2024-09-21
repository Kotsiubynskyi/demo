package com.gl.eugene.demo.rest.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.eugene.demo.model.Rating;
import com.gl.eugene.demo.rest.dto.RatingDto;
import com.gl.eugene.demo.rest.exception.RestEntityNotFoundException;
import com.gl.eugene.demo.service.RatingService;

@Component
public class RatingRestService implements RatingRestServiceIfc {

    private RatingService ratingService;
    private ObjectMapper mapper;

    public RatingRestService(RatingService ratingService, ObjectMapper mapper) {
        this.ratingService = ratingService;
        this.mapper = mapper;
    }

    @Override
    public RatingDto createRating(RatingDto newRatingDto) {
        Rating newRating = mapper.convertValue(newRatingDto, Rating.class);
        Rating rating = ratingService.createRating(newRating);
        return mapper.convertValue(rating, RatingDto.class);
    }

    @Override
    public Optional<RatingDto> getRating(String playerId) {
        Optional<Rating> rating = ratingService.geRating(playerId);
        if (rating.isEmpty()) {
            throw new RestEntityNotFoundException();
        }

        return rating.map(rate -> mapper.convertValue(rate, RatingDto.class));
    }

    @Override
    public Optional<RatingDto> updateRating(RatingDto updatedRatingDto) {
        Rating rating = mapper.convertValue(updatedRatingDto, Rating.class);
        Optional<RatingDto> updatedRating = ratingService.updateRating(rating)
                .map(ratingEntity -> mapper.convertValue(ratingEntity, RatingDto.class));

        if (updatedRating.isEmpty()) {
            throw new RestEntityNotFoundException();
        }
        
        return updatedRating;
    }

}
