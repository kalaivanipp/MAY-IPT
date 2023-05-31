package com.adactin.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.adactin.baseclass.BaseClass;
import com.adactin.helper.File_Reader_Manager;

import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features="src\\test\\java\\com\\adactin\\feature\\Feature.feature", 
glue="com.adactin.stepdefinition", 
tags="@smokeTest",
monochrome=true, 
dryRun=false,
//strict=true,
plugin={"html:Report/Cucumber-Report", 
"pretty",		
"json:Report/JsonReport.json",
"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"})

public class TestRunner{
	public static WebDriver driver;	
	@BeforeClass
	public static void Setup() throws Throwable{	
		//String browser=File_Reader_Manager.getInstance().getInstanceCR().Launch();
		//driver=BaseClass.Launch(browser);//this flie (OR) below two lines equal
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\Driver1\\chromedriver.exe");
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();		
	}
@AfterClass
public static void tearDown() {
	driver.close();
}
}
