package com.TestNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Ignore;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestAmazon {
	public static WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions copt = new ChromeOptions();
			copt.addArguments("Incognito");
			copt.addArguments("start-maximized");
			driver = new ChromeDriver(copt);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fsign%2Fs%3Fk%3Dsign%2Bin%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung Galaxy Mobiles");			
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			

			System.out.println("Current Thread id:" + Thread.currentThread().getId());
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			
	WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fopt = new FirefoxOptions();
			fopt.addArguments("Incognito");
			fopt.addArguments("start-maximized");
			driver = new FirefoxDriver(fopt);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in");
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung Galaxy Mobiles");
			System.out.println("Current Thread id:" + Thread.currentThread().getId());
		}
	}

}