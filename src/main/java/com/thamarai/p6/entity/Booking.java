package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    public Booking() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getDate() { return date; }

	public void setDate(String date) { this.date = date; }
    
}
