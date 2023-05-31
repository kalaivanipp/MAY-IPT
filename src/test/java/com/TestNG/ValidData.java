package com.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidData {
	public WebDriver driver;

	//@Test(retryAnalyzer=Retry.class)==Enable this to IretrtAnalyser
	@Test
	private void assertion() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions copt = new ChromeOptions();
		copt.addArguments("Incognito");
		copt.addArguments("start-maximized");
		driver = new ChromeDriver(copt);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/");

		String expected = "G-mail";
		String actual = driver.getTitle();
//Hard Assert==Validation
//Assert.assertEquals(actual, expected);

//Soft Assert==Verification
		SoftAssert sa = new SoftAssert();
		AssertJUnit.assertEquals(actual, expected);
		sa.assertAll();// To go back original copy

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kalaivanipp@gmail.com");

	}

}
