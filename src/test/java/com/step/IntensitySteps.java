package com.step;

import com.arenko.commonutils.*;
import com.arenko.model.TotalCarbonEmissionData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

public class IntensitySteps extends RestUtils{
	
	Response response = null;
	public  Logger logger = LogManager.getLogger(RestUtils.class);

	
	@When("I get the carbon intensity details {string}")
	public void i_get_the_carbon_intensity_for_last_thirty_mins_intensity(String path) {
		RequestSpecification request = getCommonSpec();
		request.basePath(path);
		this.response= sendRequest(request,ApplicationConstants.GET_REQUEST,null);
	}

	@Then("validate the repsonse code {int}")
	public void response_code_validation(int repsonsecode) throws  IOException {
		Assert.assertEquals(this.response.getStatusCode(),repsonsecode);
	}
	
	@Then("validate the repsonse body with SOT file {string}")
	public void response_body_validation(String filename) throws  IOException {
		TotalCarbonEmissionData dataFromApi = this.response.getBody().as(TotalCarbonEmissionData.class);
		TotalCarbonEmissionData dataFromSOT = deserialize( filename,TotalCarbonEmissionData.class);
		
		logger.info("API..."+ dataFromApi.toString());
		logger.info("API..."+ dataFromSOT.toString());

		//dataFromApi.equals(dataFromSOT);
		
		Assert.assertEquals(dataFromApi.equals(dataFromSOT), true);

		
	}

	
}
