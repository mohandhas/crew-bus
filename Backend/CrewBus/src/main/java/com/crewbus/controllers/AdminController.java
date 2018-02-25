package com.crewbus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crewbus.dao.AdminDAO;
import com.crewbus.model.Bookings;
import com.crewbus.model.Crew;
import com.crewbus.model.Driver;

@RestController
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	AdminDAO adminDAO;

	@RequestMapping(value = "showPendingRequests", method = RequestMethod.GET)
	public List<Bookings> bookRide() {
		return adminDAO.showRequests();
	}

	@RequestMapping(value = "crewDetails/{id}", method = RequestMethod.GET)
	public Crew showCrewDetails(@PathVariable int id) {
		return adminDAO.showCrewDetails(id);
	}
	
	@RequestMapping(value = "driverDetails/{id}", method = RequestMethod.GET)
	public Driver showDriverDetails(@PathVariable int id) {
		return adminDAO.showDriverDetails(id);
	}
	
	@RequestMapping(value = "showAvailableDrivers", method = RequestMethod.GET)
	public List<Driver> availableDrivers() {
		return adminDAO.showAvailableDrivers();
	}
}
