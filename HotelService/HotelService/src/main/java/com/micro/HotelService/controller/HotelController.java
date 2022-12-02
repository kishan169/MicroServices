package com.micro.HotelService.controller;

import com.micro.HotelService.exception.ResourceNotFoundException;
import com.micro.HotelService.model.Hotel;
import com.micro.HotelService.model.Rating;
import com.micro.HotelService.service.HotelService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) throws ResourceNotFoundException {
        Hotel hotel = hotelService.getHotel(hotelId);
        List<Rating> ratings = this.restTemplate.getForObject("http://localhost:8090/ratings/hotels/"+hotelId,List.class);
        hotel.setRatings(ratings);
        return ResponseEntity.status(HttpStatus.FOUND).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.status(HttpStatus.FOUND).body(hotelService.getAllHotels());
    }
}
