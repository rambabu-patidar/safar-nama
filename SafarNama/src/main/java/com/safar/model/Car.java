package com.safar.model;

public class Car {
	
	private String id;
	private String regNumber;
	private String nameAndModel;
	private String transType;
	private int yearofManufacture;
	private double rentalPrice;
	private double mileage;
	private int sittingCapacity;
	private String photoURL;
	
	public Car() {
		
	}
	
	public Car(String id, String regNumber, String nameAndModel, String transType, int yearofManufacture, double rentalPrice,
			double mileage, int sittingCapacity, String photoURL) {
		super();
		this.id = id;
		this.regNumber = regNumber;
		this.nameAndModel = nameAndModel;
		this.transType = transType;
		this.yearofManufacture = yearofManufacture;
		this.rentalPrice = rentalPrice;
		this.mileage = mileage;
		this.sittingCapacity = sittingCapacity;
		this.photoURL = photoURL;
	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getNameAndModel() {
		return nameAndModel;
	}

	public void setNameAndModel(String nameAndModel) {
		this.nameAndModel = nameAndModel;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public int getYearofManufacture() {
		return yearofManufacture;
	}

	public void setYearofManufacture(int yearofManufacture) {
		this.yearofManufacture = yearofManufacture;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getSittingCapacity() {
		return sittingCapacity;
	}

	public void setSittingCapacity(int sittingCapacity) {
		this.sittingCapacity = sittingCapacity;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	
}
