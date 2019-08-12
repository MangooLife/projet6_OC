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
@Table(name = "db_projet6_OC.comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@Column(name = "description")
    private String description;
	
	@Column(name = "publication_date")
    private String publicationDate;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName = "id")
	@OrderBy
    private Person person;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="topo_id", referencedColumnName = "id")
    @OrderBy
    private Topo topo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="site_id", referencedColumnName = "id")
    @OrderBy
    private Site site;
   
    public Comment() {}
	
    public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getPublicationDate() { return publicationDate; }

	public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }

	public Person getPerson() { return person; }

	public void setPerson(Person person) { this.person = person; }

	public Topo getTopo() { return topo; }

	public void setTopo(Topo topo) { this.topo = topo; }

	public Site getSite() { return site; }

	public void setSite(Site site) { this.site = site; }
	
}
