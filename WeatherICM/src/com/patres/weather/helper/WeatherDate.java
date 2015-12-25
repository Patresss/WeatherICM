package com.patres.weather.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherDate {
	
	private Date date;
	private String imageWeatherDate;

	private static final Logger LOGGER = Logger.getLogger(WeatherDate.class.getName());
	
	
	public WeatherDate() {
		this.date = new Date();
	}
	
	public String getImageWeatherDate() {
		setDateToLink();
		return imageWeatherDate;
	}
	
	private void setDateToLink() {
		DateFormat day = new SimpleDateFormat("yyyyMMdd");
		DateFormat hour = new SimpleDateFormat("HH");
		imageWeatherDate = day.format(date) + getAcceptableHour(hour.format(date));
		LOGGER.log(Level.INFO, "Current image date: " + imageWeatherDate);
	}

	private String getAcceptableHour(String hour) {
		int acceptableHour = Integer.parseInt(hour);
		acceptableHour = acceptableHour/6 * 6;
		String hourString = Integer.toString(acceptableHour);

		return hourString.length() == 2 ? hourString : "0" + hourString;
	}
	
	public void backTime() {
		final int RECEDING_TIME = -6;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, RECEDING_TIME);
		this.date = cal.getTime();
	}
	

}
