package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.adactin.baseclass.BaseGoibiboClass;
import com.adactin.pom.Goibibo_WebElements_POM;
import com.adactin.runner.TestRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboRunner extends BaseGoibiboClass {
	public static WebDriver driver=GoibiboRunner.driver;	
	Goibibo_WebElements_POM pom = new Goibibo_WebElements_POM(driver);	
	@BeforeTest
	public static void Setup() throws Throwable {		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		browserLaunch("chrome");
		getUrl("https://www.goibibo.com/flight-review/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!602838584772!e!goibibo!c!&gad=1&gclid=EAIaIQobChMImeeHpqyc_wIVRGx9Ch0-BAhrEAAYASAAEgKsH_D_BwE&t=bf22aa34ba45a67398e2b05da5dff3baef09b6b7");
	}	
	@Test
	public void Runner(){
		inputValuestoElement(pom.getBillAddress(), "11-101, Yogimallavaram, Tiruchanoor, Tirupati");
		inputValuestoElement(pom.getPinCode(), "517503");
		selectValuesfromDD(pom.getState(), "value", "Andhra Pradesh");
		
		elementClick(pom.getConfirm());
		
		selectValuesfromDD(pom.getTitleMr(), "value", "Ms");
		inputValuestoElement(pom.getFname(), "Kalaivani");
		inputValuestoElement(pom.getLname(), "Raman");
		
		elementClick(pom.getAdult2());
		selectValuesfromDD(pom.getTitleMr(), "value", "Mr");
		inputValuestoElement(pom.getFname(), "Roja");
		inputValuestoElement(pom.getLname(), "Raman");
		
		elementClick(pom.getAdult3());
		selectValuesfromDD(pom.getTitleMr(), "value", "Ms");
		inputValuestoElement(pom.getFname(), "Hasya");
		inputValuestoElement(pom.getLname(), "Raman");
		
		elementClick(pom.getAdult4());
		selectValuesfromDD(pom.getTitleMr(), "value", "Mr");
		inputValuestoElement(pom.getFname(), "Dhawan");
		inputValuestoElement(pom.getLname(), "Raman");
		
		inputValuestoElement(pom.getEmail(), "kalaivanipp@gmail.com");
		elementClick(pom.getProceed());	
	}

	@AfterTest
	public static void tearDown() {
		driver.close();
	}

}
