package com.hacktiv8.transportation.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;
  
  @NotBlank
  @Size(min = 1, max = 40)
  private String firstname;
  
  @NotBlank
  @Size(min = 1, max = 40)
  private String lastname;
  
  @NotBlank
  @Size(min = 1, max = 40)
  private String mobilenumber;
  
  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

/**
 * @return the firstname
 */
public String getFirstname() {
	return firstname;
}

/**
 * @param firstname the firstname to set
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}

/**
 * @return the lastname
 */
public String getLastname() {
	return lastname;
}

/**
 * @param lastname the lastname to set
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}

/**
 * @return the mobilenumber
 */
public String getMobilenumber() {
	return mobilenumber;
}

/**
 * @param mobilenumber the mobilenumber to set
 */
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}
  
}
