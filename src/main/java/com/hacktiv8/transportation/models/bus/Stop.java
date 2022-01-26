package com.hacktiv8.transportation.models.bus;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;

@Entity
@Table(name = "public.stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int fare;
    private String code;
    private String name;
    private String detail;
    
    @OneToMany(
    		mappedBy = "sourcestop",
    		cascade = CascadeType.ALL
    		)
    private List<Trip> trip;
    
    @OneToMany(
    		mappedBy = "deststop",
    		cascade = CascadeType.ALL
    		)
    private List<Trip> trip2;
    
 
 
//    
  //default const
  	public Stop() {
  		
  	}
  	//const
  	public Stop(long id, Trip...trip) {
  		this.id = id;
  		this.trip = Stream.of(trip).collect(Collectors.toList());
  		this.trip.forEach(x -> x.setSourcestop(this));
  		
  		this.trip2 = Stream.of(trip).collect(Collectors.toList());
  		this.trip2.forEach(x -> x.setDeststop(this));
  		
  	}
  	
    
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the fare
	 */
	public int getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(int fare) {
		this.fare = fare;
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
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
    
    
}

