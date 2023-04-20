package com.beClean.soba1.soba1.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beClean.soba1.soba1.Entities.Hotel;
import com.beClean.soba1.soba1.Repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	HotelRepository hotelRepository;
	
	public Iterable<Hotel> getAllHotels() {
	    return hotelRepository.findAll();
	  }
public Hotel getHotelById(int id) {
	Optional<Hotel>optionalHotel = hotelRepository.findById(id);
	if(!optionalHotel.isPresent()) {
		throw new IllegalArgumentException("hotel not found");
	}
	return optionalHotel.get();
}
public void saveOrUpdate(Hotel hotel) {
    hotelRepository.save(hotel);
  }

  public void delete(int id) {
    hotelRepository.deleteById(id);
  }

}
