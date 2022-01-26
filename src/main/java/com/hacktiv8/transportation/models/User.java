package com.hacktiv8.transportation.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.hacktiv8.transportation.models.bus.Agency;
import com.hacktiv8.transportation.models.bus.Ticket;


@Entity
@Table(name = "public.users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  
  @NotBlank
  @Size(max = 120)
  private String firstname;
  
  @NotBlank
  @Size(max = 120)
  private String lastname;
  
  @NotBlank
  @Size(max = 120)
  private String mobilenumber;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "public.user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Agency> agencys;

	@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	public User() {
	}

	public User( String email, String firstname, String lastname, String mobilenumber , String password) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.password = password;
	}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

/**
 * @return the firstname
 */
public String getFirstname() {
	return firstname;
}

/**
 * @param firstname the firstname to set
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}

/**
 * @return the lastname
 */
public String getLastname() {
	return lastname;
}

/**
 * @param lastname the lastname to set
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}

/**
 * @return the mobilenumber
 */
public String getMobilenumber() {
	return mobilenumber;
}

/**
 * @param mobilenumber the mobilenumber to set
 */
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}

///**
// * @return the agencys
// */
//public List<Agency> getAgencys() {
//	return agencys;
//}
//
///**
// * @param agencys the agencys to set
// */
//public void setAgencys(List<Agency> agencys) {
//	this.agencys = agencys;
//}

///**
// * @return the tickets
// */
//public List<Ticket> getTickets() {
//	return tickets;
//}
//
///**
// * @param tickets the tickets to set
// */
//public void setTickets(List<Ticket> tickets) {
//	this.tickets = tickets;
//}
  
}
