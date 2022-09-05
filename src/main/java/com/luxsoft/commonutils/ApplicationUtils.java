package com.luxsoft.commonutils;

import java.io.IOException;


import com.luxsoft.model.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApplicationUtils extends RestUtils {
	private final String ORDER_ENDPOINT_PATH = ApplicationConstants.ORDER_END_POINT;

	public String getPath() {
		return ORDER_ENDPOINT_PATH;
	}

	public String getOrderIdFromResponse(Response response) {
		Order order = response.getBody().as(Order.class);
		return String.valueOf(order.getOrderId());
	}

	public Response getOrderFromRestAPI(String orderId, RequestSpecification rSpec) {

		rSpec = getCommonSpec().cookie("token", getAuthorizationToken()).basePath(getBasePath(orderId));
		return sendRequest(rSpec, ApplicationConstants.GET_REQUEST, null);
	}

	public boolean verifyOrderValuesAreAsExpected(Response response, int orderId) throws IOException {
		ReadCSV readcsv = new ReadCSV();
		Order order = readcsv.getOrderDetailsFromSOT(orderId);
		return order.equals(response.getBody().as(Order.class));
	}

	public String getBasePath(String orderId) {
		return String.format("%s/%s", getPath(), orderId);
	}
}
