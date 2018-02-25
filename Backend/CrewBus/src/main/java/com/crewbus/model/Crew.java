package com.crewbus.model;

public class Crew {

	private int id;
	private String name;
	private String phone;
	private String password;
	private double latitude;
	private double longitude;

	public Crew() {
		super();
	}

	@Override
	public String toString() {
		return "Crew [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}

	public Crew(int id, String name, String phone, String password, double latitude, double longitude) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
