package com.crewbus.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.crewbus.dao.AdminDAO;
import com.crewbus.mapper.CrewMapper;
import com.crewbus.mapper.DriverMapper;
import com.crewbus.mapper.PendingRequestMapper;
import com.crewbus.model.Bookings;
import com.crewbus.model.Crew;
import com.crewbus.model.Driver;
import com.crewbus.utility.Query;

public class AdminDAOImpl implements AdminDAO {

	private JdbcTemplate jdbcTemplate;
	private final Logger logger = Logger.getLogger(AdminDAOImpl.class);

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public List<Bookings> showRequests() {
		List<Bookings> checker;
		try {
			checker = jdbcTemplate.query(Query.SHOW_REQUESTS, new PendingRequestMapper());
		} catch (Exception e) {
			logger.error(e);
			checker = null;
		}
		if (checker == null) {
			return checker;
		}
		return checker;
	}

	public Crew showCrewDetails(int id) {
		return jdbcTemplate.queryForObject(Query.SHOW_CREW_DETAILS, new Object[] { id }, new CrewMapper());

	}

	public Driver showDriverDetails(int id) {
		return jdbcTemplate.queryForObject(Query.SHOW_DRIVER_DETAILS, new Object[] { id }, new DriverMapper());

	}

	public List<Driver> showAvailableDrivers() {
		List<Driver> checker;
		try {
			checker = jdbcTemplate.query(Query.SHOW_AVAILABLE_CARS, new DriverMapper());
		} catch (Exception e) {
			logger.error("No Pending Requests Found" + e);
			checker = null;
		}
		if (checker == null) {
			return checker;
		}
		return checker;
	}

}
