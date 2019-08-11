package com.thamarai.p6.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class TopoSite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4808360298517332138L;

	@EmbeddedId
	private TopoSiteId id; 
	
	@ManyToOne
	@MapsId("topo_id")
    @JoinColumn(name = "topo_id")
    private Topo topo;
	
	@ManyToOne
	@MapsId("site_id")
    @JoinColumn(name = "site_id")
    private Site site;
	
	public TopoSite() {}

	public Topo getTopo() { return topo; }

	public void setTopo(Topo topo) { this.topo = topo; }

	public Site getSite() { return site; }

	public void setSite(Site site) { this.site = site; }
	
}
