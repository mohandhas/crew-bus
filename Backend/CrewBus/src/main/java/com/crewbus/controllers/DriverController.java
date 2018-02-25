package com.crewbus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crewbus.customizedexceptions.CustomizedBadRequestException;
import com.crewbus.dao.DriverDAO;
import com.crewbus.model.CrewToDriver;
import com.crewbus.model.Distance;
import com.crewbus.model.Driver;

@RestController
@RequestMapping("driver")
public class DriverController {

	@Autowired
	DriverDAO driverDAO;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void addDriver(@RequestBody Driver driver) {
		if (!driverDAO.register(driver)) {
			throw new CustomizedBadRequestException("Not Registered");
		}
	}

	@RequestMapping(value = "edit", method = RequestMethod.PUT)
	public Driver editDriver(@RequestBody Driver driver) {
		if (!driverDAO.editdriver(driver)) {
			throw new CustomizedBadRequestException("Not Edited!");
		}
		return driver;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Driver loginDriver(@RequestBody Driver driver) {
		Driver checker = driverDAO.login(driver);
		if (checker == null) {
			throw new CustomizedBadRequestException("In Valid Credentials!");
		}
		return checker;
	}

	@RequestMapping(value = "updateLocation", method = RequestMethod.PUT)
	public void updateLocation(@RequestBody Driver driver) {
		if (!driverDAO.updateLocation(driver)) {
			throw new CustomizedBadRequestException("Location not updating!");
		}
	}

	@RequestMapping(value = "acceptRide", method = RequestMethod.POST)
	public Driver acceptRide(@RequestBody CrewToDriver crewToDriver) {
		Driver acceptedDriver = driverDAO.acceptRide(crewToDriver);
		if (acceptedDriver == null) {
			throw new CustomizedBadRequestException("Ride Not Accepted!");
		}
		return acceptedDriver;
	}

	@RequestMapping(value = "startRide/{id}", method = RequestMethod.PUT)
	public void startRide(@PathVariable int id) {
		if (!driverDAO.startRide(id)) {
			throw new CustomizedBadRequestException("Ride Not Started!");
		}
	}

	@RequestMapping(value = "endRide/{id}", method = RequestMethod.PUT)
	public void endRide(@PathVariable int id) {
		if (!driverDAO.endRide(id)) {
			throw new CustomizedBadRequestException("Ride Not Ended Propely!");
		}
	}

	@RequestMapping(value = "cancelRide/{id}", method = RequestMethod.PUT)
	public void cancelRideDriver(@PathVariable int id) {
		if (!driverDAO.cancelRide(id)) {
			throw new CustomizedBadRequestException("Not Cancelled!");
		}
	}

	@RequestMapping(value = "checkDistance", method = RequestMethod.POST)
	public void checkForStartRide(@RequestBody Distance dis) {
		if (!driverDAO.checkForStartRide(dis)) {
			throw new CustomizedBadRequestException("Driver haven't arrived!");
		}

	}
}
