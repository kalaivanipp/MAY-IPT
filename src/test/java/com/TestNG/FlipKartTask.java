package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FlipKartTask {
	WebDriver driver;
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Greens Selenium Practice\\Driver1\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
//1.Navigate to FlipKart
		driver.get("https://www.flipkart.com/?ef_id=75f8f84132071c04f3349bdac12bcc3a:G:s&s_kwcid=AL!739!10!76484942419895!76485137405439&semcmpid=sem_F1167BY7_Brand_adcenter");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//2.Close Login Module
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
//3.Mouse Over the Menu Electronics-->MI Link
		driver.findElement(By.xpath("//img[@alt='Electronics']")).click();//click on Electronics
		
		//Mouse Over Electronics
		WebElement ElecElement = driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		Actions s=new Actions(driver);
        s.moveToElement(ElecElement).build().perform();
        
        //Mouse Over Mi Item
        WebElement MiElement = driver.findElement(By.xpath("//a[@title='Mi']"));
        s.moveToElement(MiElement).build().perform();
        MiElement.click();
//4.Verify "Latest from MI" label on the search result page
        WebElement NewestFirstElement = driver.findElement(By.xpath("//div[contains(@class, '_10UF8M') and text()='Newest First']"));
        NewestFirstElement.click();
        
//5.Change the price Slider(Use Action Class)
        WebElement PriceBarElement = driver.findElement(By.xpath("//div[@class='_3uDYxP']"));
        //WebElement PriceBarElement = driver.findElement(By.xpath("//div[@class='_31Kbhn WC_zGJ']"));
        //s.dragAndDropBy(PriceBarElement, 30, 0).build().perform();
        s.moveToElement(PriceBarElement).click().build().perform();
        
//6.choose the third option from the Max DropDown Box under price Slider (Handle DropDown)        
        WebElement MaxElement = driver.findElement(By.xpath("//div[@class='_3uDYxP']"));
        Select sel=new Select(MaxElement);
        sel.selectByIndex(2);
        
//7. Search For "redmi go (black, 8 gb)" in the search bar
        WebElement SearchElement = driver.findElement(By.xpath("//input[@class='_3704LK']"));
        SearchElement.sendKeys("redmi go (black, 8 gb)");
        driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
        
//8. click on the first product displayed on the screen
        driver.findElement(By.xpath("//div[contains(@class, '_4rR01T') and (text() = 'Redmi Go (Black, 8 GB)')]")).click();
        
//9.Verify that the product amount should be >=0(Use Switch to New Window)
        WebElement PriceElement = driver.findElement(By.xpath("//div[contains(@class, '_30jeq3 _16Jk6d') and (text() = '₹5,999')]"));
        String amount = PriceElement.getText();
        int amountRs=ParseInt(amount);
        System.out.println("Amount in Rs.:" +amountRs);
        if(amountRs>=0) {
        	System.out.println("Amount is greater than 0");
        }
//10.Click on the image Thumb nail which displays play video icon (Use IFRame)
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='_1JqCrR']"));
        driver.switchTo().frame(frameElement);
        driver.findElement(By.xpath("//div[@class='_3g-Cpg']")).click();
//11.Enter Delivery Pincode by KeyBoard Event
         
//12.Click on the "View Details" link under "Delivery PinCode"
        
//13.Click on "Add to Cart"
//14. Close the Browser
      driver.quit();
}
	private static int ParseInt(String amount) {
		// TODO Auto-generated method stub
		return 0;
	}}
