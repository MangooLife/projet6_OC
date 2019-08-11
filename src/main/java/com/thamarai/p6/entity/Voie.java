package com.thamarai.p6.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
    private String cotation;
    
    @Column(name = "width")
    private Long width;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="secteur_id")
    @OrderBy
    private Secteur secteur;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voie", cascade = CascadeType.ALL)
    @OrderBy
    private Set<Longueur> longueurs = new HashSet<Longueur>();
    
    public Voie() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getCotation() { return cotation; }

	public void setCotation(String cotation) { this.cotation = cotation; }

	public Long getWidth() { return width; }

	public void setWidth(Long width) { this.width = width; }

	public Secteur getSecteur() { return secteur; }

	public void setSecteur(Secteur secteur) { this.secteur = secteur; }

	public Set<Longueur> getLongueurs() { return longueurs; }

	public void setLongueurs(Set<Longueur> longueurs) { this.longueurs = longueurs; }
	
}
