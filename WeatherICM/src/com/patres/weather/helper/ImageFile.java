package com.patres.weather.helper;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageFile {

	private String imageUrl;
	private String destinationFile;

	private static final Logger LOGGER = Logger.getLogger(ImageFile.class
			.getName());

	public ImageFile(String imageUrl, String destinationFile) {
		this.imageUrl = imageUrl;
		this.destinationFile = destinationFile;
	}

	public void saveImage() {
		BufferedImage image = null;
		try {
			URL url = new URL(imageUrl);
			image = ImageIO.read(url);
			ImageIO.write(image, "png", new File(destinationFile));

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	public void openFile() {
		File file = new File(destinationFile);
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(file);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	public long sizeOfFile() {
		File file = new File(destinationFile);
		long sizeOfFile = file.length();
		LOGGER.log(Level.INFO, "Size of file: " + sizeOfFile);
		return sizeOfFile;
	}

}
