package com.thamarai.p6.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "db_projet6_OC.site")
public class Site {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "label")
    private Integer label;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "image")
    private String image;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    @OrderBy
    private Person person;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "site")
    @OrderBy
    private Set<Secteur> secteurs = new HashSet<Secteur>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "site")
    @OrderBy
    private Set<Comment> comments = new HashSet<Comment>();
    
    @ManyToMany(mappedBy = "topoSites")
    @OrderBy
    private Set<Topo> topos = new HashSet<Topo>();

    public Site() {}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Integer getLabel() { return label; }

	public void setLabel(Integer label) { this.label = label; }

	public Person getPerson() { return person; }

	public void setPerson(Person person) { this.person = person;}

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public String getImage() { return image; }

	public void setImage(String image) { this.image = image; }

	public Set<Secteur> getSecteurs() { return secteurs; }

	public void setSecteurs(Set<Secteur> secteurs) { this.secteurs = secteurs; }

	public Set<Comment> getComments() { return comments; }

	public void setComments(Set<Comment> comments) { this.comments = comments; }

	public Set<Topo> getTopos() { return topos; }

	public void setTopos(Set<Topo> topos) { this.topos = topos; }	
}
