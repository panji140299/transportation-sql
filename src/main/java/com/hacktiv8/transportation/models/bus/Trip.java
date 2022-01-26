package com.hacktiv8.transportation.models.bus;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "public.trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int fare;
    private String journeyTime;
    
    @ManyToOne
	@JoinColumn
	private Bus bus;
    
    @ManyToOne
	@JoinColumn
	private Agency agency;
    
    @OneToMany(
    		mappedBy = "trip",
    		cascade = CascadeType.ALL
    		)
    private List<TripSchedule> tripSchedule;
    
    @ManyToOne
	@JoinColumn
	private Stop sourcestop;
    
    @ManyToOne
	@JoinColumn
	private Stop deststop;
    
    public Trip() {
    	
    }
    public Trip(Integer fare, String journeyTime) {
		this.fare = fare;
		this.journeyTime = journeyTime;
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
	 * @return the journeyTime
	 */
	public String getJourneyTime() {
		return journeyTime;
	}
	/**
	 * @param journeyTime the journeyTime to set
	 */
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}
	
	/**
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}
	/**
	 * @param bus the bus to set
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}
	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
//	/**
//	 * @return the tripSchedule
//	 */
//	public List<TripSchedule> getTripSchedule() {
//		return tripSchedule;
//	}
//	/**
//	 * @param tripSchedule the tripSchedule to set
//	 */
//	public void setTripSchedule(List<TripSchedule> tripSchedule) {
//		this.tripSchedule = tripSchedule;
//	}
	/**
	 * @return the sourceStop
	 */
	/**
	 * @return the stop
	 */
	/**
	 * @return the sourcestop
	 */
	public Stop getSourcestop() {
		return sourcestop;
	}
	/**
	 * @param sourcestop the sourcestop to set
	 */
	public void setSourcestop(Stop sourcestop) {
		this.sourcestop = sourcestop;
	}
	
	public Stop getDeststop() {
		return deststop;
	}
	/**
	 * @param deststop the deststop to set
	 */
	public void setDeststop(Stop deststop) {
		this.deststop = deststop;
	}
	@Override
	public String toString() {
		return "Trip [id=" + id + ", fare=" + fare + ", journeyTime=" + journeyTime + ", bus=" + bus + ", agency="
				+ agency + ", tripSchedule=" + tripSchedule + ", sourcestop=" + sourcestop + ", deststop=" + deststop
				+ "]";
	}
	 
}

