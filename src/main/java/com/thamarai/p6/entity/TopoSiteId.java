package com.thamarai.p6.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TopoSiteId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6511209256031214095L;
	private Long topo;
	private Long site;
	
	public Long getTopo() { return topo; }
	
	public void setTopo(Long topo) { this.topo = topo; }

	public Long getSite() { return site; }
	
	public void setSite(Long site) { this.site = site; }
}
