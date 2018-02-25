package com.crewbus.dao;

import com.crewbus.model.CrewToDriver;
import com.crewbus.model.Distance;
import com.crewbus.model.Driver;

public interface DriverDAO {

	public boolean register(Driver driver);

	public boolean editdriver(Driver driver);

	public Driver login(Driver driver);

	public boolean updateLocation(Driver driver);

	public Driver acceptRide(CrewToDriver crewToDriver);

	public boolean cancelRide(int id);

	public boolean startRide(int id);

	public boolean endRide(int id);

	public boolean checkForStartRide(Distance dis);
}
