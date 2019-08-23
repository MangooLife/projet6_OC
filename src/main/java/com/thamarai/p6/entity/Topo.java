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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
    
    @Column(name = "image")
    private String image;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    @OrderBy
    private Person person;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="booking_id", referencedColumnName = "id")
    @OrderBy
    private Booking booking;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "topo")
    @OrderBy
    private Set<Comment> comments = new HashSet<Comment>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		  name = "topo_site", 
    		  joinColumns = @JoinColumn(name = "topo_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "site_id"))
    private Set<Site> topoSites  = new HashSet<Site>();
    
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

	public String getImage() { return image; }

	public void setImage(String image) { this.image = image; }

	public Person getPerson() { return person; }

	public void setPerson(Person person) { this.person = person; }

	public Booking getBooking() { return booking; }

	public void setBooking(Booking booking) { this.booking = booking; }

	public Set<Comment> getComments() { return comments; }

	public void setComments(Set<Comment> comments) { this.comments = comments; }

	public Set<Site> getTopoSites() { return topoSites; }

	public void setTopoSites(Set<Site> topoSites) { this.topoSites = topoSites; }
	
}
