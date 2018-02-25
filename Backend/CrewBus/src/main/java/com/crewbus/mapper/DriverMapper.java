package com.crewbus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.crewbus.model.Driver;

public class DriverMapper implements org.springframework.jdbc.core.RowMapper<Driver> {

	public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {

		Driver driver = new Driver();

		driver.setId(rs.getInt("DRIVER_ID"));
		driver.setName(rs.getString("DRIVER_NAME"));
		driver.setPhone(rs.getString("DRIVER_PHONE"));
		driver.setBusNumber(rs.getString("BUS_NUMBER"));
		driver.setPassword(rs.getString("PASSWRD"));
		driver.setLatitude(rs.getDouble("LATITUDE"));
		driver.setLongitude(rs.getDouble("LONGITUDE"));
		driver.setAvailable(rs.getBoolean("IS_AVAILABLE"));
		return driver;
	}

}