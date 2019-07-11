package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.topo")
public class Topo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "place")
    private String place;
    
    @Column(name = "parution_date")
    private String parutionDate;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "person_id")
    private Long personId;
    
    @Column(name = "booking_id")
    private Long bookingId;
    
    public Topo() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getPlace() { return place; }

	public void setPlace(String place) { this.place = place; }

	public String getParutionDate() { return parutionDate; }

	public void setParutionDate(String parutionDate) { this.parutionDate = parutionDate; }

	public String getStatus() { return status; }

	public void setStatus(String status) { this.status = status; }

	public Long getPersonId() { return personId; }

	public void setPersonId(Long personId) { this.personId = personId; }

	public Long getBookingId() { return bookingId; }

	public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

}
