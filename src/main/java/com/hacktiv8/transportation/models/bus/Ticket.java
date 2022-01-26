package com.hacktiv8.transportation.models.bus;

import javax.persistence.*;

import com.hacktiv8.transportation.models.User;


@Entity
@Table(name = "public.ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int seatNumber;
    private boolean cancellable;
    private String journeyDate;
    
    @ManyToOne
	@JoinColumn
	private User passenger;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private TripSchedule tripschedule;
    
    
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	public Ticket(Integer seatNumber, boolean cancellable, String journeyDate, User passenger, TripSchedule tripSchedule ) {
		this.seatNumber = seatNumber;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.passenger = passenger;
		this.tripschedule = tripSchedule;
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
	 * @return the seatNumber
	 */
	public int getSeatNumber() {
		return seatNumber;
	}
	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	/**
	 * @return the cancellable
	 */
	public boolean isCancellable() {
		return cancellable;
	}
	/**
	 * @param cancellable the cancellable to set
	 */
	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}
	/**
	 * @return the journeyDate
	 */
	public String getJourneyDate() {
		return journeyDate;
	}
	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	/**
	 * @return the passenger
	 */
	public User getPassenger() {
		return passenger;
	}
	/**
	 * @param passenger the passenger to set
	 */
	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}
	/**
	 * @return the tripschedule
	 */
	public TripSchedule getTripschedule() {
		return tripschedule;
	}
	/**
	 * @param tripschedule the tripschedule to set
	 */
	public void setTripschedule(TripSchedule tripschedule) {
		this.tripschedule = tripschedule;
	}

	/**
	 * @return the user
	 */

	
    
    

    
}

