package com.TestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAnnotations {
	public static WebDriver driver;
	
	@BeforeSuite
	private void setProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\Driver1");
		
		}
	
	@BeforeTest
	private void BrowserLaunch() {
		driver=new ChromeDriver();
		
	}	
	@BeforeClass
	private void getUrl() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//impicit wait
	}
	
	@BeforeMethod
	private void signIn() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("KalaivaniGreens");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Kalai@Adactin");
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}
	@Test
	
	private void SearchHote() throws IOException {
		WebElement location = driver.findElement(By.id("location"));
		Select locations=new Select(location);
		locations.selectByIndex(2);
		
		WebElement hotel = driver.findElement(By.id("hotels"));
		Select hotels=new Select(hotel);
		hotels.selectByIndex(1);
		
		WebElement room = driver.findElement(By.id("room_type"));
		Select roomtype=new Select(room);
		roomtype.selectByValue("Double");
		
		WebElement numofroom = driver.findElement(By.id("room_nos"));
		Select numofrooms=new Select(numofroom);
		numofrooms.selectByVisibleText("2 - Two");
		
		WebElement checkindate = driver.findElement(By.id("datepick_in"));
		checkindate.click();
		checkindate.clear();
		checkindate.sendKeys("12/10/2022");
		
		WebElement checkoutdate = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		checkoutdate.click();
		checkoutdate.clear();
		checkoutdate.sendKeys("22/10/2022");
		
		WebElement Adultpr = driver.findElement(By.id("adult_room"));
		Select Adultspr=new Select(Adultpr);
		Adultspr.selectByVisibleText("3 - Three");
		
		WebElement childpr = driver.findElement(By.id("child_room"));
		Select childspr=new Select(childpr);
		childspr.selectByVisibleText("4 - Four");
	
		driver.findElement(By.xpath("//input[@value='Search']")).click();//Search for Hotel Booking
		
		//driver.findElement(By.xpath("//input[@value='Reset']")).click();//Reset Search Hotel
		
		driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();//Radio Button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();//Continue
	}
		
		@Test
		private void BookHotel() {
			
		//Book A Hotel
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Kalaivani");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Pandu Rangan");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("11-101, Yogimallavaram, Tiruchanoor Post");
		driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys("4321 8765 9123 4567");
		
		WebElement cardType = driver.findElement(By.id("cc_type"));
		Select cardsType=new Select(cardType);
		cardsType.selectByVisibleText("American Express");
		
		WebElement month = driver.findElement(By.id("cc_exp_month"));
		Select months=new Select(month);
		months.selectByVisibleText("December");
		
		WebElement year = driver.findElement(By.id("cc_exp_year"));
		Select years=new Select(year);
		years.selectByVisibleText("2022");
		
		driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("1234");
		driver.findElement(By.id("book_now")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		
		@Test
		private void TakeScreenShot() {
		//Take Screen shot of Confirmation Booking 
			
		TakesScreenshot ts=(TakesScreenshot) driver;
        File Source=ts.getScreenshotAs(OutputType.FILE);
        File Destination=new File("C:\\Users\\kalai\\Green Practice\\Flight Booking\\ScreenShot\\image4.png");
        try {
			FileHandler.copy(Source, Destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	private void SearchHomePage() {
		driver.findElement(By.xpath("//a[@href='SearchHotel.php']")).click();
	}
	
	@AfterClass
	private void SignOut() {
		driver.findElement(By.xpath("//a[@href='Logout.php']"));
	}
       
	@AfterTest
	private void close() {
		driver.close();
	}
	
	@AfterSuite
    private void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
}
