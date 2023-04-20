package com.beClean.soba1.soba1.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beClean.soba1.soba1.Entities.Booking;
import com.beClean.soba1.soba1.Entities.Booking.status_rezervacije;
import com.beClean.soba1.soba1.Service.BookingService;

@RestController
public class BookingController {
@Autowired
	BookingService bookingService;

@GetMapping("/bookings")
     public Iterable<Booking>getAllBooking(){
	return bookingService.getAllBookings();
}

@GetMapping("/booking/{id}")
public Booking getBookingById(@PathVariable int id) {
	return bookingService.getBookingById(id);
}

private static class CreateBookingRequest {
    private int person_id;
    private int room_id;
    private Date datum_od;
    private Date datum_do;
	
    public CreateBookingRequest(int person_id, int room_id, Date datum_od, Date datum_do) {
		
		this.person_id = person_id;
		this.room_id = room_id;
		this.datum_od = datum_od;
		this.datum_do = datum_do;
	}
    
    

	public CreateBookingRequest() {
	}



	public int getPerson_id() {
		return person_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public Date getDatum_od() {
		return datum_od;
	}

	public Date getDatum_do() {
		return datum_do;
	}
    
    
  }

private static class UpdateBookingStatusRequest {
    private status_rezervacije status_rezervacije;
  }

public BookingController(BookingService bookingService) {
	this.bookingService = bookingService;
}

public BookingController() {
}

public BookingService getBookingService() {
	return bookingService;
}


}
