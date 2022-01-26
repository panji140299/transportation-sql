package com.hacktiv8.transportation.payload.request.bus;


public class BusDto {
	private String code;
	private String capacity;
	private String make;
	private long agency;
	
	public BusDto() {
		
	}

	public BusDto(String code, String capacity, String make, long agency) {
		super();
		this.code = code;
		this.capacity = capacity;
		this.make = make;
		this.agency = agency;
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
	public long getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(long agency) {
		this.agency = agency;
	}
	
}

