package com.thamarai.p6.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "date")
    private String date;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "booking")
    @OrderBy
    private Set<Topo> topos = new HashSet<Topo>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		  name = "person_book", 
    		  joinColumns = @JoinColumn(name = "booking_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "person_id"))
    @OrderBy
    private Set<Person> bookingPerson  = new HashSet<Person>();
    
    public Booking() {};

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getDate() { return date; }

	public void setDate(String date) { this.date = date; }

	public Set<Topo> getTopos() { return topos; }

	public void setTopos(Set<Topo> topos) { this.topos = topos; }

	public Set<Person> getBookingPerson() { return bookingPerson; }

	public void setBookingPerson(Set<Person> bookingPerson) { this.bookingPerson = bookingPerson; }  
	
}
