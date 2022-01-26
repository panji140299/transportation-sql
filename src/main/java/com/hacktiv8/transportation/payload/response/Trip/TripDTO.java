package com.hacktiv8.transportation.payload.response.Trip;

public class TripDTO {
	private int fare;
    private String journeyTime;
    private long agency;
    private long sourcestop;
    private long deststop;
    private long bus;
    
    public TripDTO() {
    	
    }

	public TripDTO(int fare, String journeyTime, long agency, long sourcestop, long deststop, long bus) {
		super();
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.agency = agency;
		this.sourcestop = sourcestop;
		this.deststop = deststop;
		this.bus = bus;
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
	 * @return the agency
	 */
	public long getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(long agency) {
		this.agency = agency;
	}

	/**
	 * @return the sourcestop
	 */
	public long getSourcestop() {
		return sourcestop;
	}

	/**
	 * @param sourcestop the sourcestop to set
	 */
	public void setSourcestop(long sourcestop) {
		this.sourcestop = sourcestop;
	}

	/**
	 * @return the deststop
	 */
	public long getDeststop() {
		return deststop;
	}

	/**
	 * @param deststop the deststop to set
	 */
	public void setDeststop(long deststop) {
		this.deststop = deststop;
	}

	/**
	 * @return the bus
	 */
	public long getBus() {
		return bus;
	}

	/**
	 * @param bus the bus to set
	 */
	public void setBus(long bus) {
		this.bus = bus;
	}
    

}