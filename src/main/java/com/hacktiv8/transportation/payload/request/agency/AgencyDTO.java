package com.hacktiv8.transportation.payload.request.agency;

import java.util.Set;

public class AgencyDTO {
	private String code;
	private String name;
	private String details;
	private long owner;

	
		
	
	public AgencyDTO(){
		
	}


	

	public AgencyDTO(String code, String name, String details, long owner) {
		super();
		this.code = code;
		this.name = name;
		this.details = details;
		this.owner = owner;

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

	/**
	 * @return the owner
	 */
	public long getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(long owner) {
		this.owner = owner;
	}



	
}