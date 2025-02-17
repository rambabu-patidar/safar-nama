package com.safar.model;

import java.sql.Date;

public class User {
	private String id;
	private String name;
	private String email;
	private Date dob;
	private String address;
	private String drivingLicense;
	
	public User () {
		// Default constructor.
	}
	
	
	public User(String id, String name, String email, Date dob, String address, String drivingLicense) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.drivingLicense = drivingLicense;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	
	
}
