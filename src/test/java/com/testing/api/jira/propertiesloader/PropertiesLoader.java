package com.testing.api.jira.propertiesloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	private static Properties properties;

	public static Properties getProperties() {
		if (properties == null) {
			try {
				FileInputStream fis = new FileInputStream("src\\test\\resources\\project.properties");
				properties = new Properties();
				properties.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	public static void setProperty(Object key, Object value) {
		if (properties == null) {
			getProperties();
		}
		properties.put(key, value);
	}
}
