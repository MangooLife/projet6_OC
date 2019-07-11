package com.thamarai.p6.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TopoSite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4808360298517332138L;

	@EmbeddedId
	private TopoSiteId id; 
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "topo_id")
    private Topo topo;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "site_id")
    private Site site;
	
	public TopoSite() {}

	public Topo getsiteTopo() { return topo; }

	public void setsiteTopo(Topo topo) { this.topo = topo; }

	public Site getSite() { return site; }

	public void setSite(Site site) { this.site = site; }
	
}
