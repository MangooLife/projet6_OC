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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "firstname")
    private String firstname;
	
	@Column(name = "lastname")
    private String lastname;

	@Column(name = "username")
    private String username;
	
	@Column(name = "birthdate")
    private String birthdate;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "status")
    private String status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    @OrderBy
    private Set<Topo> topos = new HashSet<Topo>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    @OrderBy
    private Set<Comment> comments = new HashSet<Comment>();

    public Person() {
    }

    public Person(String firstname, String lastname, String username, String birthdate, String password, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.birthdate = birthdate;
        this.password = password;
        this.status = status;
    }

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getFirstname() { return firstname; }

	public void setFirstname(String firstname) { this.firstname = firstname; }

	public String getLastname() { return lastname; }

	public void setLastname(String lastname) { this.lastname = lastname; }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getBirthdate() { return birthdate; }

	public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getStatus() { return status; }

	public void setStatus(String status) { this.status = status; }

	public Set<Topo> getTopos() { return topos; }

	public void setTopos(Set<Topo> topos) { this.topos = topos; }

	public Set<Comment> getComments() { return comments; }

	public void setComments(Set<Comment> comments) { this.comments = comments; }   
	
}
