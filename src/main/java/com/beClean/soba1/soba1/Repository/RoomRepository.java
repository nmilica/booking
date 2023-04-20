package com.beClean.soba1.soba1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.beClean.soba1.soba1.Entities.Room;
import com.beClean.soba1.soba1.Entities.Room.status;

import ch.qos.logback.core.status.Status;


public interface RoomRepository extends CrudRepository<Room, Integer>{
	
	@Query("select s from soba s where s.tip = 'trokrevetna'")
	List<Room>findAllTrokrevetna();
	
	@Query("select s from soba s where s.tip = 'dvokrevetna'")
	List<Room>findAllDvokrevetna();
	
	//nadji sobe koje su jeftinije od date cene
	List<Room>findByCenaLessThan(double cena);
	
	//sortiraj od najjeftinije do najskuplje
	List<Room> findByOrderByCenaAsc();
	
	//sortiraj od najskuplje do najjeftinije
	List<Room>findByOrderByCenaDesc();
	
	
	  Optional<Room> findById(int id);
	

     List<Room> findByStatus(Status status);

    Optional<Room> findByIdAndStatus(int id, status status);
}
