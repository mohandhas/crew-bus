package com.crewbus.model;

public class Id {
	private int crewId;
	private int driverId;

	public Id() {
		super();
	}

	public Id(int crewId, int driverId) {
		super();
		this.crewId = crewId;
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "Id [crewId=" + crewId + ", driverId=" + driverId + "]";
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

}
