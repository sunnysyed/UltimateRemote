package com.SuNnY.ultimateremote.obj;

public class GridScheduleResult {
	int Duration;
	GridChannel[] GridChannels;
	String Locale;
	String Name;
	int ServiceId;
	String StartDate;
	TimeZoneInfoGrid [] TimeZones;
	public int getDuration() {
		return Duration;
	}
	public GridChannel[] getGridChannels() {
		return GridChannels;
	}
	public String getLocale() {
		return Locale;
	}
	public String getName() {
		return Name;
	}
	public int getServiceId() {
		return ServiceId;
	}
	public String getStartDate() {
		return StartDate;
	}
	public TimeZoneInfoGrid[] getTimeZones() {
		return TimeZones;
	}
}
