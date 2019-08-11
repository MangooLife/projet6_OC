package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.longueur")
public class Longueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "cotation")
    private String cotation;
    
    @Column(name = "spit")
    private String spit;
    
    @Column(name = "width")
    private String width;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="voie_id")
    @OrderBy
    private Voie voie;
    
    public Longueur() {}
    
    public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getCotation() { return cotation; }

	public void setCotation(String cotation) { this.cotation = cotation; }

	public String getSpit() { return spit; }

	public void setSpit(String spit) { this.spit = spit; }

	public String getWidth() { return width; }

	public void setWidth(String width) { this.width = width; }

	public Voie getVoie() { return voie; }

	public void setVoie(Voie voie) { this.voie = voie; }
}
