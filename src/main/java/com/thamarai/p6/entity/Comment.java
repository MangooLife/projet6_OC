package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@Column(name = "description")
    private String description;
    
    @Column(name = "person_id")
    private String personId;
    
    public Comment() {}
	
    public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getPersonId() { return personId; }

	public void setPersonId(String personId) { this.personId = personId; }

}
