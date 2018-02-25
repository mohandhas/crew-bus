package com.crewbus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crewbus.customizedexceptions.CustomizedBadRequestException;
import com.crewbus.dao.CrewDAO;
import com.crewbus.model.Crew;
import com.crewbus.model.Id;

@RestController
@RequestMapping(value="crew")
public class CrewController {

	@Autowired
	CrewDAO crewDAO;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void addCrew(@RequestBody Crew crew) {
		if (!crewDAO.register(crew)) {
			throw new CustomizedBadRequestException("Not Registered");
		}
	}

	@RequestMapping(value = "edit", method = RequestMethod.PUT)
	public Crew editCrew(@RequestBody Crew crew) {
		if (!crewDAO.editCrew(crew)) {
			throw new CustomizedBadRequestException("Not Edited!");
		}
		return crew;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Crew loginCrew(@RequestBody Crew crew) {
		Crew checker = crewDAO.login(crew);
		if (checker == null) {
			throw new CustomizedBadRequestException("In Valid Credentials!");
		}
		return checker;
	}

	@RequestMapping(value = "updateLocation", method = RequestMethod.POST)
	public void updateLocation(@RequestBody Crew crew) {
		boolean isUpdated = crewDAO.updateCrewLocation(crew);
		if (!isUpdated) {
			throw new CustomizedBadRequestException("Ride Not Booked!");
		}
	}
	
	@RequestMapping(value = "bookRide", method = RequestMethod.POST)
	public void bookRide(@RequestBody Crew crew) {
		if (!crewDAO.bookRide(crew)) {
			throw new CustomizedBadRequestException("Ride Not Booked!");
		}
	}

	@RequestMapping(value = "cancelRide", method = RequestMethod.PUT)
	public void cancelRideCrew(@RequestBody Id id) {
		if (!crewDAO.cancelRide(id)) {
			throw new CustomizedBadRequestException("Not Cancelled!");
		}
	}
}
