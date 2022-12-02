package com.micro.Rating.service;

import com.micro.Rating.model.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);

    public List<Rating> getAllRatings();

    public List<Rating> getRatingByUser(String userId);

    public List<Rating> getRatingByHotel(String hotelId);
}
