package com.crewbus.daoimpl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.crewbus.dao.CrewDAO;
import com.crewbus.mapper.CrewMapper;
import com.crewbus.model.Crew;
import com.crewbus.model.Id;
import com.crewbus.utility.Query;
import com.crewbus.utility.UtilityMethods;

public class CrewDAOImpl implements CrewDAO {

	private JdbcTemplate jdbcTemplate;
	private final Logger logger = Logger.getLogger(CrewDAOImpl.class);

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public boolean register(Crew crew) {
		int checker;

		try {
			checker = jdbcTemplate.update(Query.CREW_REGISTER, crew.getName(), crew.getPhone(), crew.getPassword());
		} catch (Exception e) {
			System.out.println(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean editCrew(Crew crew) {
		int checker;
		try {
			checker = jdbcTemplate.update(Query.EDIT_CREW, crew.getName(), crew.getPhone(), crew.getPassword(), crew.getId());
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	private Crew findCrew(String phone) {
		Crew checker;
		try {
			checker = jdbcTemplate.queryForObject(Query.FIND_CREW, new Object[] { phone }, new CrewMapper());
		} catch (Exception e) {
			logger.error(e);
			checker = null;
		}
		return checker;
	}

	public Crew login(Crew crew) {
		Crew checker = this.findCrew(crew.getPhone());
		if (checker == null) {
			return null;
		}
		if (crew.getPassword().equals(checker.getPassword())) {
			return checker;
		}
		return null;
	}

	public boolean updateCrewLocation(Crew crew) {
		int checker;
		try {
			checker = jdbcTemplate.update(Query.UPDATE_CREW_LOCATION, crew.getLatitude(), crew.getLongitude(), crew.getPhone());
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean bookRide(Crew crew) {
		int checker;
		System.out.println(crew.getPhone());
		try {
			checker = jdbcTemplate.update(Query.BOOK_RIDE, crew.getPhone(), UtilityMethods.currentTime(), UtilityMethods.currentDate());
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

	public boolean cancelRide(Id id) {
		int checker = 0;
		try {
			checker += jdbcTemplate.update(Query.CANCEL_RIDE1, "CREW_CANCELLED", id.getCrewId(), "PENDING", "ACCEPTED");
			
			if(id.getDriverId()!=0)
			{
				checker += jdbcTemplate.update(Query.CANCEL_RIDE2, id.getDriverId());
			}
		} catch (Exception e) {
			logger.error(e);
			checker = 0;
		}
		return checker != 0;
	}

}
