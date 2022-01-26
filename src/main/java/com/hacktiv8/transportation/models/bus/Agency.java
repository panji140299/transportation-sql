package com.hacktiv8.transportation.models.bus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hacktiv8.transportation.models.User;



@Table(name = "public.agency")
@Entity
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private String name;
	private String details;
	
	@ManyToOne
	@JoinColumn
	private User owner;
	
	@OneToMany(
	mappedBy = "agency",
	cascade = CascadeType.ALL
	)
	private List<Bus> buss;
	
	@OneToMany(
	mappedBy = "agency",
	cascade = CascadeType.ALL
	)
	private List<Trip> trip;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
//	/**
//	 * @return the buss
//	 */
//	public List<Bus> getBuss() {
//		return buss;
//	}
//	/**
//	 * @param buss the buss to set
//	 */
//	public void setBuss(List<Bus> buss) {
//		this.buss = buss;
//	}
	/**
	 * @return the user
	 */
	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
//	/**
//	 * @return the trip
//	 */
//	public List<Trip> getTrip() {
//		return trip;
//	}
//	/**
//	 * @param trip the trip to set
//	 */
//	public void setTrip(List<Trip> trip) {
//		this.trip = trip;
//	}

	
	
	
	
	
}
