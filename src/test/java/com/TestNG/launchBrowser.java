package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class launchBrowser {
	public static WebDriver driver;
  
  @BeforeSuite
  public void launchBrowserTestNG() {
	  long StartTime=System.currentTimeMillis();
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Desktop\\Selenum Jars and GoogleChrome\\chromedriver.exe");
	    driver=new ChromeDriver();
	    long EndTime=System.currentTimeMillis();
	    Long TotalTime=StartTime-EndTime;
	    System.out.println("Total Time taken by Driver before Launching any Browser:"+TotalTime);
  }
  @Test
  public void openAdact() {
	  driver.get("https://adactinhotelapp.com/");
  }
  
  @Test
  public void openAmazon() {
	  driver.get("https://www.amazon.in/?tag=msndeskabkin-21&hvadid=72705384516477&hvqmt=e&hvbmt=be&hvdev=c&ref=pd_sl_7qhce485bd_e");
	  
  }
  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
