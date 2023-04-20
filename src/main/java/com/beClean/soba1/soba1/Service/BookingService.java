package com.beClean.soba1.soba1.Service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beClean.soba1.soba1.Entities.Booking;
import com.beClean.soba1.soba1.Entities.Booking.status_rezervacije;
import com.beClean.soba1.soba1.Entities.Person;
import com.beClean.soba1.soba1.Entities.Room;
import com.beClean.soba1.soba1.Entities.Room.status;
import com.beClean.soba1.soba1.Repository.BookingRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	RoomService roomService;
	@Autowired
	PersonService personService;
	
	public Iterable<Booking>getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public Booking getBookingById(int id) {
Optional<Booking>bOptional = bookingRepository.findById(id);
if(!bOptional.isPresent()) {
	throw new IllegalArgumentException("Rezervacija " + id + " nije pronajena");
}
return bOptional.get();
}

	 private Booking updateBookingStatus(status_rezervacije status, Booking booking) {
		    booking.setStatus_Rezervacije(status);
		    return bookingRepository.save(booking);
		  }

		  private void markRoomAsAvailable(Booking booking) {
		    final Room room = booking.getRoom();
		    room.setStatus(status.SLOBODNO);
		  }

		  private Booking bookRoom(int personId, Date datum_od, Date datum_do, Room room) {
return bookingRepository.save
		(Booking.buildBooking(room, personService.getPersonById(personId), datum_od, datum_do));

		  }

		  private void markRoomAsOccupied(Room room) {
		    room.setStatus(status.ZAUZETO);
		  }
	@Transactional
public Booking updateBookingStatus(int booking_id, status_rezervacije status_rezervacije) {
	Booking.validateNewStatus(status_rezervacije);
	Booking booking = getBookingById(booking_id);
	Booking.validateStateTransition(booking.getStatus_Rezervacije(), status_rezervacije);
	markRoomAsAvailable(booking);
	return updateBookingStatus(booking_id, status_rezervacije);
}
	
	 @Transactional
	  public Booking bookRoomByRoomId(int personId, int roomId, Date datum_od, Date datum_do) {
	    Room room = roomService.getRoomByIdAndStatus(roomId, status.SLOBODNO);
	    markRoomAsOccupied(room);
	    return bookRoom(personId, datum_od, datum_do, room);
	  }

	 
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
