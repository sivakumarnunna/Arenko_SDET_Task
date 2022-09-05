package com.luxsoft.commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 
 * This class is for all constants used across framework
 */

public class ApplicationConstants {

static Properties properties = new Properties();
static Logger logger = LogManager.getLogger(ApplicationConstants.class);


public static final int GET_REQUEST = 0;
public static final int POST_REQUEST = 1;
public static final int DELETE_REQUEST = 2;
public static final int PUT_REQUEST = 3;
	
	public static String BASE_URL;
	public static String USER_NAME;
    public static String PASSWORD;
	public static String SOT_PATH;
	public static String authToken;
    public static String ORDER_END_POINT;
  
	static {
		
		try {
			properties.load(new FileInputStream("applicationUnderTest.properties"));
			BASE_URL = properties.getProperty("baseURL");
			USER_NAME =  properties.getProperty("username");
			PASSWORD =   properties.getProperty("password");
			SOT_PATH   =  properties.getProperty("sotpath");
		    ORDER_END_POINT   =  properties.getProperty("orderendpoint");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
