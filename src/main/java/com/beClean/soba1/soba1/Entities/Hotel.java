package com.beClean.soba1.soba1.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;
	private String naziv, adresa, grad,drzava, opis;
	
	// dohvati listu soba u hotelu
		@OneToMany(mappedBy = "hotel")
		private List<Room> rooms;
	
	public Hotel(int hotel_id, String naziv, String adresa, String grad, String drzava, String opis) {
		this.hotel_id = hotel_id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.grad = grad;
		this.drzava = drzava;
		this.opis = opis;
	}

	public Hotel() {
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	

}
