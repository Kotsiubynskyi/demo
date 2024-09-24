package com.gl.eugene.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.eugene.demo.jpa.entity.RatingEntity;
import com.gl.eugene.demo.jpa.repository.RatingRepository;
import com.gl.eugene.demo.model.Rating;

@Service
public class RatingService implements RatingServiceIfc {

  private RatingRepository ratingRepository;
  private ObjectMapper modelMapper;

  public RatingService(RatingRepository ratingRepository, ObjectMapper modelMapper) {
    this.ratingRepository = ratingRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void createRating(Rating newRating) {
    RatingEntity ratingEntity = new RatingEntity();

    ratingEntity.setId(newRating.getId());
    ratingEntity.setGrade(newRating.getGrade());
    ratingEntity.setTotalGames(newRating.getTotalGames());
    ratingEntity.setWonGames(newRating.getWonGames());
    ratingRepository.save(ratingEntity);
  }

  @Override
  public Optional<Rating> getRating(String playerId) {
    Optional<RatingEntity> ratingEntity = ratingRepository.findById(playerId);
    return ratingEntity.map(entity -> modelMapper.convertValue(entity, Rating.class));
  }

  @Override
  public Optional<Rating> updateRating(Rating rating) {
    if (rating == null) {
      return Optional.empty();
    }

    Optional<RatingEntity> ratingEntity = ratingRepository.findById(rating.getId());
    RatingEntity ratingToUpdate;
    if (ratingEntity.isPresent()) {
      ratingToUpdate = ratingEntity.get();
    } else {
      ratingToUpdate = new RatingEntity();
    }

    ratingToUpdate.setId(rating.getId());
    ratingToUpdate.setGrade(rating.getGrade());
    ratingToUpdate.setTotalGames(rating.getTotalGames());
    ratingToUpdate.setWonGames(rating.getWonGames());
    ratingRepository.save(ratingToUpdate);

    return Optional.of(modelMapper.convertValue(ratingToUpdate, Rating.class));

  }

}
