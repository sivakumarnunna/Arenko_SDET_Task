package com.arenko.commonutils;

import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import org.apache.logging.log4j.LogManager;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import net.serenitybdd.rest.SerenityRest;

public class RestUtils {

	public static Logger logger = LogManager.getLogger(RestUtils.class);

	/**
	 * 
	 * @return io.restassured.specification.RequestSpecification
	 * 
	 *         This method will build basic RequestSpecification object with content
	 *         type and baseURL.
	 */
	public RequestSpecification getCommonSpec() {
		RequestSpecification rSpec = SerenityRest.given();
		rSpec.contentType(ContentType.JSON).baseUri(ApplicationConstants.BASE_URL);
		return rSpec;
	}

	/**
	 * 
	 * This method will deserialize the file into POJO.
	 * 
	 * @param <T>
	 * @param filename
	 * @param T
	 * @return
	 * @throws FileNotFoundException
	 */
	public static <T> T deserialize(String filename, Type T) throws FileNotFoundException {
		FileReader reader = new FileReader(ApplicationConstants.SOT_PATH + "/" + filename);
		Gson gson = new Gson();
		T data = gson.fromJson(reader, T);
		return data;

	}

	/**
	 * This method will serialize a POJO to string.
	 * 
	 * @param object
	 * @return
	 */
	public static String serialize(Object object) {
		Gson gson = new Gson();
		String st = gson.toJson(object);
		return st;

	}

	/**
	 * Send request
	 * 
	 * @param request     details for sending the request
	 * @param requestType of the request. i.e GET, POST, PUT, DELETE, UPDATE
	 * @param url         to execute for the request
	 * @param pojo        if provided will be added to the body of request as JSON
	 *                    payload
	 * @return response received from the service by sending the request
	 */
	public Response sendRequest(RequestSpecification request, int requestType, Object pojo) {
		Response response;

		if (pojo != null) {
			String payload = serialize(pojo).toString();
			request.body(payload);
			
		}
		
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(request);
		logger.info("Request");
		logger.info("===============================");
		logger.info("URI "+queryRequest.getURI());
		logger.info("Headers "+queryRequest.getHeaders().size());
		logger.info("Headers "+queryRequest.getHeaders().toString());


		switch (requestType) {
		case ApplicationConstants.POST_REQUEST:
			if (request == null) {
				response = SerenityRest.when().post();
			} else {

				logger.info("body is..." + request.get().getBody().asString());
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
				logger.info("Response");
				logger.info("===============================");
				logger.info("Response code : "+response.getStatusCode());
				logger.info("Response Body");
				logger.info(response.getBody().asString());

			}
			break;
		}
		return response;
	}

}
