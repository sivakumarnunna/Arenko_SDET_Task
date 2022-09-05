package com.luxsoft.commonutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredRequestFilter implements Filter {
	private final Logger logger = LogManager.getLogger(RestUtils.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        if (response.statusCode() != 200) {
        	logger.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
                    response.getStatusCode() + " " + response.getStatusLine());
        }
        logger.info(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() + "\n Response Status => " +
                response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint());
        return response;
    }
}