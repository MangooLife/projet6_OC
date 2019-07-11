package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.secteur")
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "site_id")
    private Long siteId;
    
    public Secteur() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Long getSiteId() { return siteId; }

	public void setSiteId(Long siteId) { this.siteId = siteId; }
    
}
