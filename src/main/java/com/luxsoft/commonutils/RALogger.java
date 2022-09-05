package com.luxsoft.commonutils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RALogger {

	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   Logger consoleLogger = LogManager.getLogger( "console" );
	   Logger fileLogger = LogManager.getLogger( "file" );

	   private static final String MESSAGE_SEPARATOR = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

	   RALogger() {
	   }

	   public  void addToLog( String logMessage ) {
	      try {
	         byteArrayOutputStream.write( ( logMessage + "\n" ).getBytes() );
	      } catch ( IOException e ) {
	         e.printStackTrace();
	      }
	   }

	   public  synchronized void logOutput() {
	      StringBuilder log = new StringBuilder( byteArrayOutputStream.toString() );

	      if ( log.length() != 0 ) {
	         for ( String line : log.toString().split( "\n" ) ) {
	            fileLogger.info( line.replace( "\r", "" ) );
	         }
	      }

	      byteArrayOutputStream.reset();
	   }
	   
}
