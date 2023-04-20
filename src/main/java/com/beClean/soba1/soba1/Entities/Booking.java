package com.beClean.soba1.soba1.Entities;

import java.sql.Date;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.id.IdentifierGenerationException;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="rezervacija")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rezervacija_id;
	@ManyToOne
	@JoinColumn(name="soba_id")
	Room room;
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	Person person;
	Date datum_od, datum_do;
	public enum status_rezervacije {REZERVISANO, OTKAZANO, ZAVRSENO};
	
	@Enumerated(EnumType.STRING)
	private status_rezervacije status_Rezervacije;
	
	public Booking(int rezervacija_id, Room room, Person person, Date datum_od, Date datum_do,
			status_rezervacije status_Rezervacije) {
		this.rezervacija_id = rezervacija_id;
		this.room = room;
		this.person = person;
		this.datum_od = datum_od;
		this.datum_do = datum_do;
		this.status_Rezervacije = status_Rezervacije;
	}

	public Booking() {
	}

	public int getRezervacija_id() {
		return rezervacija_id;
	}

	public void setRezervacija_id(int rezervacija_id) {
		this.rezervacija_id = rezervacija_id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getDatum_od() {
		return datum_od;
	}

	public void setDatum_od(Date datum_od) {
		this.datum_od = datum_od;
	}

	public Date getDatum_do() {
		return datum_do;
	}

	public void setDatum_do(Date datum_do) {
		this.datum_do = datum_do;
	}

	public status_rezervacije getStatus_Rezervacije() {
		return status_Rezervacije;
	}

	public void setStatus_Rezervacije(status_rezervacije status_Rezervacije) {
		this.status_Rezervacije = status_Rezervacije;
	}
	
	public static Booking buildBooking(Room room, Person person, Date datum_od, Date datum_do) {
		Booking booking= new Booking();
		booking.setPerson(person);
		booking.setRoom(room);
		booking.setDatum_od(datum_od);
		booking.setDatum_do(datum_do);
		booking.setStatus_Rezervacije(status_rezervacije.REZERVISANO);
		return booking;
	}
	
	public static void validateNewStatus(status_rezervacije sRezervacije) {
		if (sRezervacije.equals(status_rezervacije.REZERVISANO)) {
			throw new IllegalArgumentException("status je vec rezervisan");
			
		}
	}
	
	public static void validateStateTransition(status_rezervacije stariStatus, status_rezervacije noviStatus) {
		if(!stariStatus.equals(status_rezervacije.REZERVISANO)) {
			throw new IdentifierGenerationException("nije moguce promeniti status rezervacije");
		}
	}

}
