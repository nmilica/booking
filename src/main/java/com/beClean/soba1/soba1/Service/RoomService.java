package com.beClean.soba1.soba1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.beClean.soba1.soba1.Entities.Room;
import com.beClean.soba1.soba1.Entities.Room.status;
import com.beClean.soba1.soba1.Repository.RoomRepository;

import ch.qos.logback.core.status.Status;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepository;
	
	public List<Room>getAllRooms(){
		return (List<Room>) roomRepository.findAll();
	
	}
	public Room getRoomById(int id) {
		return getIfPresentOrThrow(roomRepository.findById(id));
	}
    public List<Room> getAllTrokrevetna(){
	return roomRepository.findAllTrokrevetna();
}

     public List<Room>getAllDvokrevetna(){
	return roomRepository.findAllDvokrevetna();
}
     public List<Room> getRoomByCenaLessThan(@PathVariable double cena){
    	 return roomRepository.findByCenaLessThan(cena);
     }
     
     public List<Room>getByOrderByCenaAsc(){
    	 return roomRepository.findByOrderByCenaAsc();
     }
     
     public List<Room> getByOrderByCenaDesc() {
    	 return roomRepository.findByOrderByCenaDesc();
		
	}
     public List<Room>getRoomByStatus(Status status){
	 return roomRepository.findByStatus(status);
 }
     private Room getIfPresentOrThrow(Optional<Room> optionalRoom) {
    	    if (!optionalRoom.isPresent()) {
    	      throw new IllegalArgumentException();
    	    }
    	    return optionalRoom.get();
    	  }
  public Room getRoomByIdAndStatus(int id, status status) {
    	    return getIfPresentOrThrow(roomRepository.findByIdAndStatus(id, status));
    	  }
}
