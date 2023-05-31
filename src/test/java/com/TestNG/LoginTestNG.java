package com.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.utilityTest.TestUtil;
//DataProvider Example
public class LoginTestNG {
	public static WebDriver driver;
	
	@BeforeMethod
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kalai\\\\Desktop\\\\Selenum Jars and GoogleChrome\\\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.get("https://adactinhotelapp.com/");
	    driver.manage().window().maximize();	    
	}
	
	@DataProvider
	public Object[][] getLoginData() throws Exception{
		Object[][] data = TestUtil.getTestData();		
		return data;
		
	}
	
	@Test(dataProvider="getLoginData")
    public static void getTestData(String username, String password) {
	
	driver.findElement(By.name("username")).sendKeys("username");
	driver.findElement(By.name("password")).sendKeys("password");
	
	//loginButton
	driver.findElement(By.name("login")).click();
	//WebElement login=driver.findElement(By.name("login"));
	//JavascriptExecutor js=(JavascriptExecutor) driver;
	//js.executeScript("arguements[0].click", login);
                                     }
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
