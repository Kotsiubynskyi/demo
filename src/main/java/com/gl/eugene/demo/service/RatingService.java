package com.gl.eugene.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.eugene.demo.jpa.entity.RatingEntity;
import com.gl.eugene.demo.jpa.repository.RatingRepository;
import com.gl.eugene.demo.model.Rating;
import com.gl.eugene.demo.rest.exception.RestEntityNotFoundException;

@Service
public class RatingService implements RatingServiceIfc {

    private RatingRepository ratingRepository;
    private ObjectMapper modelMapper;

    public RatingService(RatingRepository ratingRepository, ObjectMapper modelMapper) {
        this.ratingRepository = ratingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Rating createRating(Rating newRating) {
        return null;
    }

    @Override
    public Optional<Rating> geRating(String playerId) {
        Optional<RatingEntity> ratingEntity = ratingRepository.findById(playerId);
        return ratingEntity.map(entity -> modelMapper.convertValue(entity, Rating.class));
    }

    @Override
    public Optional<Rating> updateRating(Rating rating) {
        if (rating == null) {
            return Optional.empty();
        }

        Optional<RatingEntity> ratingEntity = ratingRepository.findById(rating.getId());
        if (ratingEntity.isEmpty()) {
            throw new RestEntityNotFoundException();
        }

        RatingEntity ratingToUpdate = ratingEntity.get();
        ratingToUpdate.setGrade(rating.getGrade());
        ratingToUpdate.setTotalGames(rating.getTotalGames());
        ratingToUpdate.setWonGames(rating.getWonGames());
        ratingRepository.save(ratingToUpdate);

        return Optional.of(modelMapper.convertValue(ratingToUpdate, Rating.class));

    }

}
