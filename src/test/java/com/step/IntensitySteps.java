package com.step;

import com.arenko.commonutils.*;
import com.arenko.model.TotalCarbonEmissionData;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.*;

public class IntensitySteps extends RestUtils{
	
	Response response = null;
	
	@When("I get the carbon intensity details {string}")
	public void i_get_the_carbon_intensity_for_last_thirty_mins_intensity(String path) {
		RequestSpecification request = getCommonSpec();
		request.basePath(path);
		this.response= sendRequest(request,ApplicationConstants.GET_REQUEST,null);
	}

	@Then("validate the repsonse code {int}")
	public void response_code_validation(int repsonsecode) throws StreamReadException, DatabindException, IOException {
		Assert.assertEquals(this.response.getStatusCode(),repsonsecode);
	}
	
	@Then("validate the repsonse body with SOT file {string}")
	public void response_body_validation(String filename) throws StreamReadException, DatabindException, IOException {
		TotalCarbonEmissionData dataFromApi = this.response.getBody().as(TotalCarbonEmissionData.class);
		TotalCarbonEmissionData dataFromSOT = deserialize( filename,TotalCarbonEmissionData.class);
		
		RestUtils.logger.info("API..."+ dataFromApi.toString());
		RestUtils.logger.info("API..."+ dataFromSOT.toString());

		//dataFromApi.equals(dataFromSOT);
		
		Assert.assertEquals(dataFromApi.equals(dataFromSOT), true);

		
	}

	
}
