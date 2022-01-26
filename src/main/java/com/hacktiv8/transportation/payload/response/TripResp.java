package com.hacktiv8.transportation.payload.response;

public class TripResp {
		private int fare;
	    private String journeyTime;
	    private String agency;
	    private String sourcestop;
	    private String deststop;
	    private String bus;
	    
	    public TripResp() {
	    	
	    }

		public TripResp(int fare, String journeyTime, String agency, String sourcestop, String deststop, String bus) {
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
		public String getAgency() {
			return agency;
		}

		/**
		 * @param agency the agency to set
		 */
		public void setAgency(String agency) {
			this.agency = agency;
		}

		/**
		 * @return the sourcestop
		 */
		public String getSourcestop() {
			return sourcestop;
		}

		/**
		 * @param sourcestop the sourcestop to set
		 */
		public void setSourcestop(String sourcestop) {
			this.sourcestop = sourcestop;
		}

		/**
		 * @return the deststop
		 */
		public String getDeststop() {
			return deststop;
		}

		/**
		 * @param deststop the deststop to set
		 */
		public void setDeststop(String deststop) {
			this.deststop = deststop;
		}

		/**
		 * @return the bus
		 */
		public String getBus() {
			return bus;
		}

		/**
		 * @param bus the bus to set
		 */
		public void setBus(String bus) {
			this.bus = bus;
		}

		

	    
}