package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void BrowserInIt(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\Driver1\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		case "firefox":
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kalai\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		default:
			driver=null;
			break;
		}
		
	}	
	@Test
	public void verifyPageTitle() {
		driver.get("https://www.google.co.in/");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
