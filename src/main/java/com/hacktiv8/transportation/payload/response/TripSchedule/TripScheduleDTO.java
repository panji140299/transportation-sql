package com.hacktiv8.transportation.payload.response.TripSchedule;

public class TripScheduleDTO {
	private int fare;
    private String tripDate;
    private int availableSeat;
    private String tripDetail;
    private int ticketSold;
    private int trip;
    public TripScheduleDTO() {
    }
	public TripScheduleDTO(int fare, String tripDate, int availableSeat, String tripDetail, int ticketSold, int trip) {
		super();
		this.fare = fare;
		this.tripDate = tripDate;
		this.availableSeat = availableSeat;
		this.tripDetail = tripDetail;
		this.ticketSold = ticketSold;
		this.trip = trip;
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
	 * @return the tripDate
	 */
	public String getTripDate() {
		return tripDate;
	}

	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	/**
	 * @return the availableSeat
	 */
	public int getAvailableSeat() {
		return availableSeat;
	}

	/**
	 * @param availableSeat the availableSeat to set
	 */
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	/**
	 * @return the tripDetail
	 */
	public String getTripDetail() {
		return tripDetail;
	}

	/**
	 * @param tripDetail the tripDetail to set
	 */
	public void setTripDetail(String tripDetail) {
		this.tripDetail = tripDetail;
	}

	/**
	 * @return the ticketSold
	 */
	public int getTicketSold() {
		return ticketSold;
	}

	/**
	 * @param ticketSold the ticketSold to set
	 */
	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

	/**
	 * @return the trip
	 */
	public int getTrip() {
		return trip;
	}

	/**
	 * @param trip the trip to set
	 */
	public void setTrip(int trip) {
		this.trip = trip;
	}
    
}
