package com.gl.eugene.demo.jpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gl.eugene.demo.jpa.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

}
