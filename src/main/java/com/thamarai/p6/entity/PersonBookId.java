package com.thamarai.p6.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersonBookId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2851069467301544421L;
	private Long person;
	private Long book;
	
	public Long getTopo() { return person; }
	
	public void setTopo(Long person) { this.person = person; }

	public Long getSite() { return book; }
	
	public void setSite(Long book) { this.book = book; }
}
