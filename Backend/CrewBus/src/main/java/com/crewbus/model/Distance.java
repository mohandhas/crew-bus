package com.crewbus.model;

public class Distance {
	private double cLatitude;
	private double cLongitude;
	private double dLatitude;
	private double dLongitude;
	
	
	public Distance(double cLatitude, double cLongitude, double dLatitude, double dLongitude) {
		super();
		this.cLatitude = cLatitude;
		this.cLongitude = cLongitude;
		this.dLatitude = dLatitude;
		this.dLongitude = dLongitude;
	}
	public Distance() {
		super();
	}
	@Override
	public String toString() {
		return "Distance [cLatitude=" + cLatitude + ", cLongitude=" + cLongitude + ", dLatitude=" + dLatitude
				+ ", dLongitude=" + dLongitude + "]";
	}
	public double getcLatitude() {
		return cLatitude;
	}
	public void setcLatitude(double cLatitude) {
		this.cLatitude = cLatitude;
	}
	public double getcLongitude() {
		return cLongitude;
	}
	public void setcLongitude(double cLongitude) {
		this.cLongitude = cLongitude;
	}
	public double getdLatitude() {
		return dLatitude;
	}
	public void setdLatitude(double dLatitude) {
		this.dLatitude = dLatitude;
	}
	public double getdLongitude() {
		return dLongitude;
	}
	public void setdLongitude(double dLongitude) {
		this.dLongitude = dLongitude;
	}
	
	

}
