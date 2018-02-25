package com.crewbus.utility;

public class Query {
	
	private Query()
	{
	}

	public static final String SHOW_REQUESTS = "SELECT * FROM BOOKINGS WHERE BOOKING_STATUS=\"PENDING\"";
	public static final String SHOW_CREW_DETAILS = "SELECT * FROM CREW WHERE CREW_ID=?";
	public static final String SHOW_DRIVER_DETAILS = "SELECT * FROM DRIVER WHERE DRIVER_ID=?";
	public static final String SHOW_AVAILABLE_CARS = "SELECT * FROM DRIVER WHERE IS_AVAILABLE=0";
	public static final String CREW_REGISTER = "INSERT INTO CREW (CREW_NAME,CREW_PHONE,PASSWRD) VALUES (?,?,?)";
	public static final String EDIT_CREW = "UPDATE CREW SET CREW_NAME=?,CREW_PHONE=?,PASSWRD=? WHERE CREW_ID=?";
	public static final String FIND_CREW = "SELECT * FROM CREW WHERE CREW_PHONE=?";
	public static final String UPDATE_CREW_LOCATION = "UPDATE CREW SET LATITUDE=?,LONGITUDE=? WHERE CREW_PHONE=?";
	public static final String BOOK_RIDE = "INSERT INTO BOOKINGS (CREW_PHONE,BOOKING_TIME,BOOKING_DATE) VALUES (?,?,?)";
	public static final String CANCEL_RIDE1 = "UPDATE BOOKINGS SET BOOKING_STATUS=? WHERE CREW_ID=? AND (BOOKING_STATUS=? OR BOOKING_STATUS=?)";
	public static final String CANCEL_RIDE2 = "UPDATE DRIVER SET IS_AVAILABLE=0 WHERE DRIVER_ID=?";
	public static final String DRIVER_REGISTER = "INSERT INTO DRIVER (DRIVER_NAME,DRIVER_PHONE,BUS_NUMBER,PASSWRD) VALUES (?,?,?,?)";
	public static final String EDIT_DRIVER = "UPDATE DRIVER SET DRIVER_NAME=?,DRIVER_PHONE=?,PASSWRD=?, BUS_NUMBER=? WHERE DRIVER_ID=?";
	public static final String FIND_DRIVER = "SELECT * FROM DRIVER WHERE DRIVER_PHONE=?";
	public static final String UPDATE_LOCATION = "UPDATE DRIVER SET LATITUDE=?,LONGITUDE=? WHERE DRIVER_ID=?";
	public static final String ACCEPT_RIDE1 = "UPDATE BOOKINGS, DRIVER SET BOOKINGS.DRIVER_ID=?, BOOKINGS.BOOKING_STATUS=? ,DRIVER.IS_AVAILABLE=? WHERE BOOKINGS.CREW_ID=? AND BOOKINGS.BOOKING_STATUS=? AND DRIVER.IS_AVAILABLE=? AND DRIVER.DRIVER_ID=?";
	public static final String START_RIDE = "UPDATE BOOKINGS SET RIDE_START_TIME=?, RIDE_START_DATE=?, BOOKING_STATUS=? WHERE DRIVER_ID=? AND BOOKING_STATUS=?";
	public static final String END_RIDE1 = "UPDATE BOOKINGS SET RIDE_END_TIME=?, RIDE_END_DATE=?, BOOKING_STATUS=? WHERE DRIVER_ID=? AND BOOKING_STATUS=?";
	public static final String END_RIDE2 = "UPDATE DRIVER SET IS_AVAILABLE=? WHERE DRIVER_ID=?";
	public static final String CANCEL_RIDE1_DRIVER = "UPDATE BOOKINGS SET BOOKING_STATUS=? WHERE DRIVER_ID=? AND BOOKING_STATUS=?";
}