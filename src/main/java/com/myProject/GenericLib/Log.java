package com.myProject.GenericLib;

	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;

	public class Log {
		
			protected static Logger Log = Logger.getLogger("Log");
			
			public static void configure() {
			 PropertyConfigurator.configure("Log4j.properties");
			}
			//configure("log4j.properties");
	// Initialize Log4j logs
		

		public static void startTestCase(String sTestCaseName){
	     Log.info("Started "+ sTestCaseName);
	      }
	
	public static void endTestCase(String sTestCaseName){
		Log.info("Finished  "+sTestCaseName);
	    }

	public static void info(String message) {
	        Log.info(message);
	        }
	public static void warn(String message) {
	    Log.warn(message);
	    }
	public static void error(String message) {
	    Log.error(message);
	    }
	public static void fatal(String message) {
	    Log.fatal(message);
	    }
	public static void debug(String message) {
	    Log.debug(message);
	    }
	}

