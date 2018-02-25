package com.crewbus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.crewbus.model.Bookings;


public class PendingRequestMapper implements org.springframework.jdbc.core.RowMapper<Bookings> {

	public Bookings mapRow(ResultSet rs, int rowNum) throws SQLException {

		Bookings bookings = new Bookings();

		bookings.setCrewId(rs.getInt("CREW_ID"));
		
		return bookings;
	}

}