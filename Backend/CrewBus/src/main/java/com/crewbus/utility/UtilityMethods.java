package com.crewbus.utility;

public class UtilityMethods {

	private UtilityMethods()
	{
		
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	public static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		return (dist);
	}

	public static String currentDate() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(dt);
	}

	public static String currentTime() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("HH:mm:ss");
		return sdf2.format(dt);
	}
}
