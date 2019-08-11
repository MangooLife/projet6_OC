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
@Table(name = "db_projet6_OC.secteur")
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="site_id")
    @OrderBy
    private Site site;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "secteur", cascade = CascadeType.ALL)
    @OrderBy
    private Set<Voie> voies = new HashSet<Voie>();
    
    public Secteur() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Site getSite() { return site; }

	public void setSite(Site site) { this.site = site; }

	public Set<Voie> getVoies() { return voies; }

	public void setVoies(Set<Voie> voies) { this.voies = voies;}
    
}
