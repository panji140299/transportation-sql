package com.hacktiv8.transportation.models.bus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "public.bus")
@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String code;
	
	@Column(nullable = false)
	private String capacity;
	
	@Column(nullable = false)
	private String make;
	
	@ManyToOne
	@JoinColumn
	private Agency agency;
	
	@OneToMany(
	mappedBy = "bus",
	 cascade = CascadeType.ALL
		)
	 		
	private List<Trip> trip;
	

	
	public Agency agency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
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
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}
//	/**
//	 * @return the user
//	 */
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
//	


	
}
