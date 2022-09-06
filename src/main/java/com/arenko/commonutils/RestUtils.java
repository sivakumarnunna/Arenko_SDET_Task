package com.arenko.commonutils;

import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import org.apache.logging.log4j.LogManager;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class RestUtils {
	
	
	public static Logger logger = LogManager.getLogger(RestUtils.class);
	
	public RequestSpecification getCommonSpec() {
		RequestSpecification rSpec = SerenityRest.given();
		rSpec.contentType(ContentType.JSON).baseUri(ApplicationConstants.BASE_URL);
		return rSpec;
	}

	 public static <T> T deserialize(String filename, Type T) throws FileNotFoundException {
		 FileReader reader = new FileReader(ApplicationConstants.SOT_PATH+"/"+filename);
	        Gson gson = new Gson();
	        T data = gson.fromJson(reader, T);
	        return data;

	    }
	public static String serialize(Object object) {
	        Gson gson = new Gson();
	        String st = gson.toJson(object);
	        return st;

	    }

	public Response sendRequest(RequestSpecification request, int requestType, Object pojo) {
		Response response;

		if (pojo != null) {
			String payload = serialize(pojo).toString();
			request.body(payload);
		}

		switch (requestType) {
		case ApplicationConstants.POST_REQUEST:
			if (request == null) {
				response = SerenityRest.when().post();
			} else {
				
				logger.info("body is..."+request.get().getBody().asString());
				System.out.println("body is..."+request.get().getBody().asString());
				
				
				response = request.post();
			}
			break;
		case ApplicationConstants.DELETE_REQUEST:
			if (request == null) {
				response = SerenityRest.when().delete();
			} else {
				response = request.delete();
			}
			break;
		case ApplicationConstants.PUT_REQUEST:
			if (request == null) {
				response = SerenityRest.when().put();
			} else {
				response = request.put();
			}
			break;
		case ApplicationConstants.GET_REQUEST:
		default:
			if (request == null) {
				response = SerenityRest.when().get();
			} else {
				response = request.get();
			}
			break;
		}
		return response;
	}

}
