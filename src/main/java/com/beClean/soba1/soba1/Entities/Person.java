package com.beClean.soba1.soba1.Entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="korisnik")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int korisnik_id;
	private String ime,prezime, email, lozinka;
	
	@OneToMany(mappedBy = "person")
	private List<Booking>rezervacije;
	
	public Person(int korisnik_id, String ime, String prezime, String email, String lozinka) {
		this.korisnik_id = korisnik_id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
	}

	public Person() {
	}

	public int getKorisnik_id() {
		return korisnik_id;
	}

	public void setKorisnik_id(int korisnik_id) {
		this.korisnik_id = korisnik_id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	

}
