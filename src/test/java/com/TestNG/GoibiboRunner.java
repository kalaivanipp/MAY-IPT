package com.TestNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.adactin.baseclass.BaseGoibiboClass;
import com.adactin.pom.Goibibo_WebElements_POM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboRunner extends BaseGoibiboClass {
	Goibibo_WebElements_POM pom = new Goibibo_WebElements_POM();
	public static WebDriver driver;

	@BeforeClass
	public static void Setup() throws Throwable {		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}
