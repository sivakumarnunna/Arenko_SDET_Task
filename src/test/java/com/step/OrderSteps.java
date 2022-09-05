package com.step;

import java.io.IOException;

import com.luxsoft.model.*;
import com.luxsoft.commonutils.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class OrderSteps extends ApplicationUtils{
	
	Response res = null;
	
	int orderId;
	
	@When("I get order details from getNaceDetails with {string}")
	public void i_get_order_details_from_getNaceDetails_with(String orderId) {
		this.orderId = Integer.parseInt(orderId);
   res = sendRequest(getCommonSpec().cookie("token", getAuthorizationToken()).basePath(getBasePath(orderId)), ApplicationConstants.GET_REQUEST, null);

	}
	@Then("I verify the details with csv file")
	public void i_verify_the_details_with_csv_file() throws IOException {
		
		ReadCSV readcsv = new ReadCSV();
		
		System.out.println(this.orderId);
		
		Order order = readcsv.getOrderDetailsFromSOT(this.orderId);
		System.out.println(order.toString());
		order.equals(res.getBody().as(Order.class));
		
		
	}	
	
	
	
	
}
