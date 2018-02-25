package com.crewbus.daoimpl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.crewbus.dao.DriverDAO;
import com.crewbus.mapper.DriverMapper;
import com.crewbus.model.CrewToDriver;
import com.crewbus.model.Distance;
import com.crewbus.model.Driver;
import com.crewbus.utility.Query;
import com.crewbus.utility.UtilityMethods;

public class DriverDAOImpl implements DriverDAO {

	private JdbcTemplate jdbcTemplate;
	private static final Logger logger = Logger.getLogger(DriverDAOImpl.class);
	private static final String ACCEPTED="ACCEPTED";
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public boolean register(Driver driver) {
		int checker;

		try {
			checker = jdbcTemplate.update(Query.DRIVER_REGISTER, driver.getName(), driver.getPhone(),
					driver.getBusNumber(), driver.getPassword());
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean editdriver(Driver driver) {
		int checker;
		try {
			checker = jdbcTemplate.update(Query.EDIT_DRIVER, driver.getName(), driver.getPhone(), driver.getPassword(),
					driver.getBusNumber(), driver.getId());
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	private Driver findDriver(String phone) {
		Driver checker;
		try {
			checker = jdbcTemplate.queryForObject(Query.FIND_DRIVER, new Object[] { phone }, new DriverMapper());
		} catch (Exception e) {
			logger.error(e);
			checker = null;
		}
		return checker;
	}

	public Driver login(Driver driver) {
		Driver checker = this.findDriver(driver.getPhone());
		if (checker == null) {
			return null;
		}
		if (driver.getPassword().equals(checker.getPassword())) {
			return checker;
		}
		return null;
	}

	public boolean updateLocation(Driver driver) {
		int checker;
		try {
			checker = jdbcTemplate.update(Query.UPDATE_LOCATION, driver.getLatitude(), driver.getLongitude(),
					driver.getId());
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public Driver acceptRide(CrewToDriver crewToDriver) {
		int checker;
		Driver driver = null;
		try {
			checker = jdbcTemplate.update(Query.ACCEPT_RIDE1, crewToDriver.getDriverId(), ACCEPTED, 1,
					crewToDriver.getCrewId(), "PENDING", 0, crewToDriver.getDriverId());

			driver = jdbcTemplate.queryForObject(Query.SHOW_DRIVER_DETAILS, new Object[] { crewToDriver.getDriverId() },
					new DriverMapper());

		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		if (checker != 0) {
			return driver;
		}
		return null;
	}

	public boolean startRide(int id) {
		int checker;
		try {
			checker = jdbcTemplate.update(Query.START_RIDE, UtilityMethods.currentTime(), UtilityMethods.currentDate(),
					"EN ROUTE", id, ACCEPTED);
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean endRide(int id) {
		int checker = 0;
		try {

			checker += jdbcTemplate.update(Query.END_RIDE1, UtilityMethods.currentTime(), UtilityMethods.currentDate(),
					"RIDE COMPLETED", id, "EN ROUTE");

			checker += jdbcTemplate.update(Query.END_RIDE2, 0, id);

		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean cancelRide(int id) {
		int checker = 0;
		try {
			checker += jdbcTemplate.update(Query.CANCEL_RIDE1_DRIVER, "DRIVER CANCELLED", id, ACCEPTED);
			checker += jdbcTemplate.update(Query.END_RIDE2, 0, id);
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean checkForStartRide(Distance dis) {
		double calculatedDistance = UtilityMethods.distance(dis.getcLatitude(), dis.getcLongitude(), dis.getdLatitude(),
				dis.getdLongitude()) * 1000;
		return calculatedDistance < 100;
	}

}
