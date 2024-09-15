package com.gl.eugene.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.eugene.demo.jpa.repository.RatingRepository;
import com.gl.eugene.demo.model.Rating;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Optional<Rating> geRating(String playerId) {
        Optional<com.gl.eugene.demo.jpa.entity.Rating> ratingEntity = ratingRepository.findById(playerId);
        return ratingEntity.map(entity -> modelMapper.map(entity, Rating.class));
    }

    public void saveRating(Rating rating) {
        if (rating == null) {
            return;
        }

        com.gl.eugene.demo.jpa.entity.Rating ratingEntity = modelMapper.map(rating,
                com.gl.eugene.demo.jpa.entity.Rating.class);
        ratingRepository.save(ratingEntity);

    }

}
