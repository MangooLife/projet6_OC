package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.person_book")
public class PersonBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookId;
	
	public PersonBook() {}

	public Long getPersonId() { return personId; }

	public void setPersonId(Long personId) { this.personId = personId; }

	public Long getBookId() { return bookId; }

	public void setBookId(Long bookId) { this.bookId = bookId; }
	
}
