package com.micro.HotelService.service;

import com.micro.HotelService.exception.ResourceNotFoundException;
import com.micro.HotelService.model.Hotel;
import com.micro.HotelService.repo.HotelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelDao hotelDao;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelDao.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) throws ResourceNotFoundException {
        Optional<Hotel> hotel = hotelDao.findById(hotelId);
        if(!hotel.isPresent()) throw new ResourceNotFoundException("Hotel Not found Exception");
        return hotel.get();
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDao.findAll();
    }
}
