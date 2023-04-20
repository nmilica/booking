package com.beClean.soba1.soba1.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity(name="soba")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="soba_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	Hotel hotel;
	private String tip;
	private double cena;
	private String opis;
	public enum status {SLOBODNO, ZAUZETO};	
	@Enumerated(EnumType.STRING)
	private status status;
	
	@OneToMany(mappedBy = "room")
	private List<Booking>listaRezervacija;
	
	//@Version
	//int versionNumber = 0;

	public Room(int id, Hotel hotel, String tip, double cena, String opis,status status) {
		this.id = id;
		this.hotel = hotel;
		this.tip = tip;
		this.cena = cena;
		this.opis = opis;
		this.status = status;
	}

	public Room() {
	}

	public int getSoba_id() {
		return id;
	}

	public void setSoba_id(int soba_id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}
	
	
	

}
