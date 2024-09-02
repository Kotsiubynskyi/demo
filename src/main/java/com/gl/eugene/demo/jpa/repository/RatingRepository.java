package com.gl.eugene.demo.jpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gl.eugene.demo.jpa.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {

}
