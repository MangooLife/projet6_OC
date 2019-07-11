package com.thamarai.p6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.topo_site")
public class TopoSite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topo_id")
    private Long topoId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    private Long siteId;
	
	public TopoSite() {}

	public Long getPersonId() { return topoId; }

	public void setPersonId(Long personId) { this.topoId = personId; }

	public Long getBookId() { return siteId; }

	public void setBookId(Long bookId) { this.siteId = bookId; }
	
}
