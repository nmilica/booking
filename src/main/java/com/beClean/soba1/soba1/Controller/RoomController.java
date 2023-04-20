package com.beClean.soba1.soba1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beClean.soba1.soba1.Entities.Room;
import com.beClean.soba1.soba1.Service.RoomService;

import ch.qos.logback.core.status.Status;

@RestController
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@GetMapping("/room")
	public List<Room>getAllRooms(){
		return(List<Room>) roomService.getAllRooms();
	}

	@GetMapping("/room/{id}")
	public Room getRoomById(@PathVariable int id) {
		return roomService.getRoomById(id);
	}
	
	@GetMapping("/trokrevetna")
	public List<Room>getAllTrokrevetna(){
		return roomService.getAllTrokrevetna();
	}
	
	@GetMapping("/dvokrevetna")
	public List<Room>findAlldvokrevetna(){
		return roomService.getAllDvokrevetna();
	}
	
	@GetMapping("/jeftinije/{cena}")
	public List<Room>getRoomByCenaLessThan(@PathVariable double cena){
		return roomService.getRoomByCenaLessThan(cena);
	}
	@GetMapping("/najjeftinije")
	public List<Room>getByOrderByCenaAsc(){
		return roomService.getByOrderByCenaAsc();
	}
	@GetMapping("/najskuplje")
	public List<Room>GetByOrderByCenaDesc(){
		return roomService.getByOrderByCenaDesc();
	}
	@GetMapping("/{status}")
	public List<Room>getRoomByStatus(Status status){
		return roomService.getRoomByStatus(status);
	}
}