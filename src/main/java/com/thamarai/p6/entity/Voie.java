package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.voie")
public class Voie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "cotation")
    private Long cotation;
    
    @Column(name = "width")
    private Long width;
    
    @ManyToOne
    private Secteur secteur;
    
    public Voie() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Long getCotation() { return cotation; }

	public void setCotation(Long cotation) { this.cotation = cotation; }

	public Long getWidth() { return width; }

	public void setWidth(Long width) { this.width = width; }

	public Secteur getSecteurId() { return secteur; }

	public void setSecteurId(Secteur secteur) { this.secteur = secteur; }
    
}
