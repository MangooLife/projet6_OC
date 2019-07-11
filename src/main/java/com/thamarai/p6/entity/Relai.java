package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.relai")
public class Relai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "coordinateX")
    private Long coordinateX;
    
    @Column(name = "coordinateY")
    private Long coordinateY;
    
    public Relai() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public Long getCoordinateX() { return coordinateX; }

	public void setCoordinateX(Long coordinateX) { this.coordinateX = coordinateX; }

	public Long getCoordinateY() { return coordinateY; }

	public void setCoordinateY(Long coordinateY) { this.coordinateY = coordinateY; }
    
}
