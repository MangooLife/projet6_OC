package com.thamarai.p6.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PersonBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8494325532250499062L;

	@EmbeddedId
	private PersonBookId id; 
	
	@ManyToOne
	@MapsId("person_id")
    @JoinColumn(name = "person_id")
    private Person person;
	
	@ManyToOne
	@MapsId("booking_id")
    @JoinColumn(name = "booking_id")
    private Booking booking;
	
	public PersonBook() {}

	public Person getPerson() { return person; }

	public void setPerson(Person person) { this.person = person; }

	public Booking getBook() { return booking; }

	public void setBook(Booking booking) { this.booking = booking; }
	
}
