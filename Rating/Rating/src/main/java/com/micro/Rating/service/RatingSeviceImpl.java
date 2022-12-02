package com.micro.Rating.service;

import com.micro.Rating.model.Rating;
import com.micro.Rating.repo.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingSeviceImpl implements RatingService{

    @Autowired
    private RatingDao ratingDao;

    @Override
    public Rating createRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingDao.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingDao.findAll();
    }

    @Override
    public List<Rating> getRatingByUser(String userId) {
        return ratingDao.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return ratingDao.findByHotelId(hotelId);
    }
}
