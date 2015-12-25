package com.patres.weather.link;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.patres.weather.helper.WeatherDate;

public class Link {

	private final static String IMAGE_DOMAIN = "http://www.meteo.pl/um/metco/mgram_pict.php?ntype=0u";// &fdate=2015081712&row=465&col=234&lang=pl";
	private final static int POSITION_X = 234;
	private final static int POSITION_Y = 465;
	private final static String LANGUAGE = "pl";
	private WeatherDate weatherDate;

	private static final Logger LOGGER = Logger.getLogger(Link.class.getName());

	public Link() {
		this.weatherDate = new WeatherDate();
	}


	public String getLink() {
		String imageDate = weatherDate.getImageWeatherDate();
		String link = IMAGE_DOMAIN + "&fdate=" + imageDate + "&row=" + POSITION_Y + "&col=" + POSITION_X + "&lang=" + LANGUAGE;
		LOGGER.log(Level.INFO, "Image link: " + link);

		return link;
	}

	public String getPreviousWeatherLink() {
		weatherDate.backTime();
		return getLink();
	}

}
