package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.site")
public class Site {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "person_id")
    private String person;

    public Site() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getLabel() { return label; }

	public void setLabel(String label) { this.label = label; }

	public String getPerson() { return person; }

	public void setPerson(String person) { this.person = person;}
    
}
