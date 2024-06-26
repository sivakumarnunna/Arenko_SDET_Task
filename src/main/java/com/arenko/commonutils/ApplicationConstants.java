package com.arenko.commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * This class is for all constants used across framework. It will read all the
 * variables from "resources\\properties\\applicationUnderTest.properties" file
 * and assgin those values to the constants here.
 */

public class ApplicationConstants {

	static Properties properties = new Properties();
	static Logger logger = LogManager.getLogger(ApplicationConstants.class);

	public static final int GET_REQUEST = 0;
	public static final int POST_REQUEST = 1;
	public static final int DELETE_REQUEST = 2;
	public static final int PUT_REQUEST = 3;
	public static final int PATCH_REQUEST = 4;

	public static String BASE_URL;
	public static String SOT_PATH;

	static {
		try {
			properties.load(new FileInputStream("resources\\properties\\applicationUnderTest.properties"));
			BASE_URL = properties.getProperty("baseURL");
			SOT_PATH = properties.getProperty("sotpath");
			logger.info("Base URL :::" + BASE_URL);
			logger.info("SOT files path :::" + SOT_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
