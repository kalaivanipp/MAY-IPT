package com.adactin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {
	public static Properties p;
	
	public ConfigFileReader() throws IOException {
	
	File f=new File("C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\src\\test\\java\\com\\adactin\\properties\\Configurationextent.properties");
	FileInputStream fis=new FileInputStream(f);
	p=new Properties();
	p.load(fis);
	}
	public String getReportConfigPath(){
		String reportConfigPath = p.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}


