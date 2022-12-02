package com.micro.HotelService.service;

import com.micro.HotelService.exception.ResourceNotFoundException;
import com.micro.HotelService.model.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel createHotel(Hotel hotel);

    public Hotel getHotel(String hotelId) throws ResourceNotFoundException;

    public List<Hotel> getAllHotels();
}
