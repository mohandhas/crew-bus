package com.crewbus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.crewbus.model.Crew;

public class CrewMapper implements org.springframework.jdbc.core.RowMapper<Crew> {

	public Crew mapRow(ResultSet rs, int rowNum) throws SQLException {

		Crew crew = new Crew();

		crew.setId(rs.getInt("CREW_ID"));
		crew.setName(rs.getString("CREW_NAME"));
		crew.setPhone(rs.getString("CREW_PHONE"));
		crew.setPassword(rs.getString("PASSWRD"));
		crew.setLatitude(rs.getDouble("LATITUDE"));
		crew.setLongitude(rs.getDouble("LONGITUDE"));

		return crew;
	}

}
