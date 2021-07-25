package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	/*
	 * 
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	private Properties prop;
	
	public Properties init_Prop() throws IOException, FileNotFoundException
	{
		
	 	prop=new Properties();
		FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
		return prop;
	}

}
	


