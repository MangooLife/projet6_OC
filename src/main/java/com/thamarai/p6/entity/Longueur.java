package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name = "voie_id")
    private Integer voieId;
    
    @Column(name = "relai_id")
    private Integer relaiId;
    
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

	public Integer getVoieId() { return voieId; }

	public void setVoieId(Integer voieId) { this.voieId = voieId; }

	public Integer getRelaiId() { return relaiId; }

	public void setRelaiId(Integer relaiId) { this.relaiId = relaiId;}

}
