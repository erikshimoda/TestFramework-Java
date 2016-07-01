package com.testframeworkdemo.framework.helpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	private static final Logger LOG = LoggerFactory.getLogger(Log.class); 
	
	public static void iniciadoCasoDeTeste(String casoDeTeste){
		Log.info(casoDeTeste);
	}


	public static void finalizadoCasoDeTeste(String casoDeTeste){
		Log.info(casoDeTeste);
	}

	public static void info(String message)
	{
		Log.info(message);
	}

}