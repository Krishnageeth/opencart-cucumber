package com.automation.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	static Properties properties = new Properties();

	public static String getProperty(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}
}
