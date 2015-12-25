package com.patres.weather;

import com.patres.weather.helper.ImageFile;
import com.patres.weather.link.Link;

public class MainApp {

	static int limit = 10;

	public static void main(String[] args) throws Exception {
		String destinationFile = "pogoda.png";
		Link link = new Link();
		String imageUrl = link.getLink();

		ImageFile imageFile = new ImageFile(imageUrl, destinationFile);
		imageFile.saveImage();

		while (imageFile.sizeOfFile() < 1024 && limit > 0) {
			imageUrl = link.getPreviousWeatherLink();
			imageFile = new ImageFile(imageUrl, destinationFile);
			imageFile.saveImage();
			limit--;
		}

		imageFile.openFile();

	}

}
