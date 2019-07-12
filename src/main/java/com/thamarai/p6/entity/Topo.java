package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    private Person person;
    
    @ManyToOne
    private Booking booking;
    
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

	public Person getPerson() { return person; }

	public void setPerson(Person person) { this.person = person; }

	public Booking getBooking() { return booking; }

	public void setBooking(Booking booking) { this.booking = booking; }

}
