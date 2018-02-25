package com.crewbus.dao;

import javax.sql.DataSource;

import com.crewbus.model.Crew;
import com.crewbus.model.Id;

public interface CrewDAO {

	void setDataSource(DataSource dataSource);

	public boolean register(Crew crew);

	public boolean editCrew(Crew crew);

	public Crew login(Crew crew);

	public boolean updateCrewLocation(Crew crew);

	public boolean bookRide(Crew crew);

	public boolean cancelRide(Id id);
}
