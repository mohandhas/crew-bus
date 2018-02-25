package com.crewbus.dao;

import java.util.List;

import com.crewbus.model.Bookings;
import com.crewbus.model.Crew;
import com.crewbus.model.Driver;

public interface AdminDAO {

	public List<Bookings> showRequests();

	public Crew showCrewDetails(int id);

	public Driver showDriverDetails(int id);

	public List<Driver> showAvailableDrivers();

}
