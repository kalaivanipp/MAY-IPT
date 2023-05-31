package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTesting {
	WebDriver driver;
	
	@Test	
	
	private void AdactinHome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Greens Selenium Practice\\Driver1\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Parallel Testing Home Page");
		System.out.println("The thread ID for Adactin Home is "+ Thread.currentThread().getId());
	}
	@Test
	private void AdactinSignIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Greens Selenium Practice\\Driver1\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/SearchHotel.php");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("KalaivaniGreens");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Kalai@Adactin");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("Parallel Testing Search Page");
		System.out.println("The thread ID for Adactin Search Page is "+ Thread.currentThread().getId());
		
	}

}
