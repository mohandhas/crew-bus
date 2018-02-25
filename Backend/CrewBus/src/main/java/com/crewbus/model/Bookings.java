package com.crewbus.model;

import java.sql.Date;
import java.sql.Time;

public class Bookings {

	private int crewId;
	private int driverId;
	private Date bookingTime;
	private Time bookingDate;
	private Date rideStartTime;
	private Time rideStartDate;
	private Date rideEndTime;
	private Time rideEndDate;

	public Bookings() {
		super();
	}

	public Bookings(int crewId, int driverId, Date bookingTime, Time bookingDate, Date rideStartTime,
			Time rideStartDate, Date rideEndTime, Time rideEndDate) {
		super();
		this.crewId = crewId;
		this.driverId = driverId;
		this.bookingTime = bookingTime;
		this.bookingDate = bookingDate;
		this.rideStartTime = rideStartTime;
		this.rideStartDate = rideStartDate;
		this.rideEndTime = rideEndTime;
		this.rideEndDate = rideEndDate;
	}

	@Override
	public String toString() {
		return "Bookings [crewId=" + crewId + ", driverId=" + driverId + ", bookingTime=" + bookingTime
				+ ", bookingDate=" + bookingDate + ", rideStartTime=" + rideStartTime + ", rideStartDate="
				+ rideStartDate + ", rideEndTime=" + rideEndTime + ", rideEndDate=" + rideEndDate + "]";
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

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Time getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Time bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getRideStartTime() {
		return rideStartTime;
	}

	public void setRideStartTime(Date rideStartTime) {
		this.rideStartTime = rideStartTime;
	}

	public Time getRideStartDate() {
		return rideStartDate;
	}

	public void setRideStartDate(Time rideStartDate) {
		this.rideStartDate = rideStartDate;
	}

	public Date getRideEndTime() {
		return rideEndTime;
	}

	public void setRideEndTime(Date rideEndTime) {
		this.rideEndTime = rideEndTime;
	}

	public Time getRideEndDate() {
		return rideEndDate;
	}

	public void setRideEndDate(Time rideEndDate) {
		this.rideEndDate = rideEndDate;
	}
}
