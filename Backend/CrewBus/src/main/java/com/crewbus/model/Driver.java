package com.crewbus.model;

public class Driver {

	private int id;
	private String name;
	private String phone;
	private String password;
	private String busNumber;
	private double latitude;
	private double longitude;
	private boolean isAvailable;

	public Driver() {
		super();
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + ", busNumber="
				+ busNumber + ", latitude=" + latitude + ", longitude=" + longitude + ", isAvailable=" + isAvailable
				+ "]";
	}

	public Driver(int id, String name, String phone, String password, String busNumber, double latitude,
			double longitude, boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.busNumber = busNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
