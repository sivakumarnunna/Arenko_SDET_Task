package com.luxsoft.commonutils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.filter.log.LogDetail;
import io.restassured.internal.print.RequestPrinter;
import io.restassured.internal.print.ResponsePrinter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LogFilter implements Filter {
	
	
	RALogger ralogger = new RALogger();

    @Override
    public Response filter( FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx ) {

       Response response = null;
	   // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

       try {

          // send the request
          response = ctx.next( requestSpec, responseSpec );

       } catch ( Exception e ) {
    	   ralogger.addToLog( "Could not connect to the environment" );
    	   ralogger.addToLog( e.getMessage() );
          throw new AssertionError( "Could not connect to the environment" );
       } finally {
          // print the request
        //  RequestPrinter.print( requestSpec, requestSpec.getMethod(), requestSpec.getURI(), LogDetail.ALL, null, new PrintStream( byteArrayOutputStream ), true );
          // add an empty line
          ralogger.addToLog( "\n" );
          if ( response != null ) {
             // print the response
         //    ResponsePrinter.print( response, response, new PrintStream( byteArrayOutputStream), LogDetail.ALL, true,null );
          }
          // add the message separator
        //  ralogger.addToLog( MESSAGE_SEPARATOR );

          // print the log
          ralogger.logOutput();
       }

       return response;
    }

	
}