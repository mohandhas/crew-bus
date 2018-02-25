package com.crewbus.model;

public class CrewToDriver {
	private String name;
	private String phone;
	private double latitude;
	private double longitude;
	private int crewId;
	private int driverId;

	public CrewToDriver() {
		super();
	}

	@Override
	public String toString() {
		return "CrewToDriver [name=" + name + ", phone=" + phone + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", crewId=" + crewId + ", driverId=" + driverId + "]";
	}

	public CrewToDriver(String name, String phone, double latitude, double longitude, int crewId, int driverId) {
		super();
		this.name = name;
		this.phone = phone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.crewId = crewId;
		this.driverId = driverId;
	}

	public int getCrewId() {
		return crewId;
	}

	public void setCrewId(int crewId) {
		this.crewId = crewId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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
