package com.beClean.soba1.soba1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beClean.soba1.soba1.Entities.Hotel;
import com.beClean.soba1.soba1.Service.HotelService;

@RestController
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/hotels")
	public Iterable<Hotel>getAllHotels(){
		return hotelService.getAllHotels();
	}
	@GetMapping("/hotel/{id}")
    public Hotel getHotelById(@PathVariable int id) {
    	return hotelService.getHotelById(id);
    }
	@DeleteMapping("/{id}")
	  public void deleteHotel(@PathVariable int id) {
	    hotelService.delete(id);
	  }
	
	@PostMapping("/hotelPost")
	  public int saveHotel(@RequestBody Hotel hotel) {
	    hotelService.saveOrUpdate(hotel);
	    return hotel.getHotel_id();
	  }
}
