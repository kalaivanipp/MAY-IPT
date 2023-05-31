package com.adactin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration_Reader {
	
public static Properties p;

public Configuration_Reader() throws Throwable{
	File f=new File("C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\src\\test\\java\\com\\adactin\\properties\\Configuration.properties");
	FileInputStream fis=new FileInputStream(f);
	p=new Properties();
	p.load(fis);
}

public String Launch(){
	String Browser=p.getProperty("browser");
	return Browser;	
}

public String url() {
	String urlname=p.getProperty("Url");
	return urlname;
	
}
}
