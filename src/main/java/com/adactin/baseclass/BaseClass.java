package com.adactin.baseclass;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
//1.method to select or getting type of Browser by passing Browser Chrome/FireFox/Internet explorer of as String
	
	public static WebDriver Launch(String value) {
	if(value.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\Driver1\\chromedriver.exe");
	    driver=new ChromeDriver();
	                                     }
	else if(value.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\Driver1\\chromedriver.exe");
	    driver=new ChromeDriver();
	                                            }
	return driver;
	}
	
//2.method(get()) to Launch Web Browser by passing URL as String
	public static void url(String value1) {
		driver.get(value1);
		driver.manage().window().maximize();
	}
//3.method to sendkeys
	public static void tosendKeys(WebElement element, String value) {
			element.sendKeys(value);	
		}
//4.method to click()
	public static void clickOnElement(WebElement element) {
		element.click();	
	}
//5.method to get Size()
	public static void getSizeOfElement(WebElement element) {
		element.getSize();
	}
//6.method to get TagName
	public static void getTagname(WebElement element) {
		element.getTagName();	
	}
//7.method to get Text()
	public static void getTextOfElement(WebElement element) {
		element.getText();
}
//8.method to CapsLock ON/OFF
	public static void capsLockOnOff() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
		
		Thread.sleep(3000);
		
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	}
	
//9.method to Robot, KeyBoard Actions/Page Up/Down/Left/Right/Enter/Ctrl+Tab
	public static void keyBoardActions(WebElement element, String action) throws Throwable {
		Robot r=new Robot();
		if(action.equalsIgnoreCase("Down")) {
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		
		else if(action.equalsIgnoreCase("Up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}else if(action.equalsIgnoreCase("Left")) {
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
		}
		else if(action.equalsIgnoreCase("Enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		else if(action.equalsIgnoreCase("Ctrl+Tab")) {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_TAB);
			
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_TAB);				
		}
		}
//10.method to DropDownBox-Single item selection
	public static void Drop_DownBox(WebElement element,String Suggestion,String value) {
				Select s=new Select(element);
			    	if(Suggestion.equalsIgnoreCase("index")) {
			    		int n = Integer.parseInt(value);
			    		s.selectByIndex(n);
			    		//System.out.println("Selected item using Single Drop Box:"+element.getText());
			    	}
			    	else if(Suggestion.equalsIgnoreCase("value")) {
			    		s.selectByValue(value);
			    		//System.out.println("Selected item using Single Drop Box:"+element.getText());
			    	}
			    	else if(Suggestion.equalsIgnoreCase("text")) {
			    	s.selectByVisibleText(value);
			    		//\System.out.println("Selected item using Single Drop Box:"+element.getText());
			    	}
			    	else {
			    		System.out.println("No such Option:");
			    	}
			    	
			    }
	
			    
//11.method to Multi-Select Drop Box
	public static void multiSelectDropBox(WebElement element, int index, String value, String Text) {
		Select s=new Select(element);
		
	    //Getting available values from Multiple Drop Box before any selection
	    List<WebElement> items1=s.getOptions();
	    System.out.println("Before Selection Items in Multiple Drop Box:");
	    for(WebElement bef:items1) {
	    	System.out.println(bef.getText());
	    }
	   //Getting Selected values from Multiple Drop Box
	    s.selectByIndex(index);
	    s.selectByValue(value);
	    s.selectByVisibleText(Text);
	    
	    if (s.isMultiple()==true) {	    
	    	List<WebElement> items2 = s.getAllSelectedOptions();
		    System.out.println("After Selection Items available in Multiple Drop Box:");
		    for(WebElement after:items2) {
		    	System.out.println("Items available after Selection Multple Drop Box:"+after.getText());
		    } }
	    	
	    	s.deselectAll();
	           System.out.println("Deselected");
	    }
	    
	public static <WebElements> void List(WebElement element) {   
		Select s=new Select(element);
	List<WebElement> items2 = s.getAllSelectedOptions();
	    System.out.println("After Selection Items available in Multiple Drop Box:");
	    for(WebElement after:items2) {
	    	System.out.println("Items available after Selection Multple Drop Box:"+after.getText());
	    }
	}
//12.method to "Take Screen Shot"
	public static void takeScreenShot(String a) {
	TakesScreenshot ts=(TakesScreenshot) driver;
    File source=ts.getScreenshotAs(OutputType.FILE);
    File Destination=new File("C:\\Users\\kalai\\Green Practice\\Maven_Practice\\Maven Screen Shot\\" + a +".png");
    try {
		FileUtils.copyFile(source, Destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}
//13.method to "getTitle"
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("Title:"+title);
	}
//14. method to get current URL
	public static void getCurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Current URL:"+url);
}
//15. method to navigate "to"
	public static void navigateTo(String toUrl) {
		driver.navigate().to(toUrl);
		//System.out.println("Navigated to:"+title);
}
//16.method to navigate "forward"
	public static void navigateForward() {
		driver.navigate().forward();
	}
//17.method to navigate "back"
		public static void navigateBack() {
			driver.navigate().back();
		}
//18.method to navigate "Refresh"
		public static void navigaterefresh() {
			driver.navigate().refresh();
		}
//19.method to navigate "quit"
		public static void quit() {
			driver.quit();;
		}
//20.method to navigate "close"
		public static void close() {
			driver.close();
		}
//21.method to "isDisplayed" to check whether an element is visible (or) available in page.
		public static void isDisplayed(WebElement element) {
			boolean displayed = element.isDisplayed();
			System.out.println("Elemnt is available in Webpage:"+ displayed);
		}
//22.method to "isEnabled" to check whether an element is editable (or) Clickable
	    public static void isEnabled(WebElement element) {
			boolean Enabled = element.isEnabled();
			System.out.println("Elemnt is Editable/Clickable in Webpage:"+ Enabled);
			}
//23.method to "isSelected" to check whether an element is Selected (or) not
	    public static void isSelected(WebElement element) {
			boolean Selected = element.isSelected();
			System.out.println("Elemnt Selected in Webpage:"+ Selected);
			}   
//24.method to "clear()" to clear the passed data in the Web Application.
	    public static void clear(WebElement element) {
	    	element.clear();
	    }
//25. method to "Alert()"
	    public void Alert(WebElement element) throws Throwable {
	    	
	    	//Simple Alert
			WebElement simplealert = driver.findElement(By.id("alertBox"));
			simplealert.click();	
			Alert a1 = driver.switchTo().alert();
			a1.accept();
			Thread.sleep(3000);
			
			//confirmation Alert
			WebElement confirmationalert = driver.findElement(By.id("confirmBox"));
			confirmationalert.click();	
			Thread.sleep(3000);
			Alert a2 = driver.switchTo().alert();
			a2.accept();
			
			//Prompt Alert
			WebElement promptalert = driver.findElement(By.id("promptBox"));
			promptalert.click();	
			Thread.sleep(3000);
			Alert a3 = driver.switchTo().alert();
			a3.sendKeys("Checking");
			a3.accept();
			String text=promptalert.getText();
			System.out.println("The text you have entered in Prompt Alert is:"+text);
					
			}
//26.method to "ifremes()"
	    public void iframes(WebElement element) {
	    	driver.switchTo().frame(0);
			WebElement iframetext= driver.findElement(By.xpath("//input[@type='text'][1]"));
			iframetext.sendKeys("Testing iFrame using Automation Demo Site");
			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();//click on iframe within an iFrame
			
			//driver.switchTo().frame(0);
			WebElement outerframe= driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
			
			driver.switchTo().frame(outerframe);
			WebElement innerframe= driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
			
			driver.switchTo().frame(innerframe);
			WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
			textbox.sendKeys("Welcome");
	    }
//27.method to"JavaScript Executor"-"scrollBy"
	    public static void scrollBy(WebElement element) {
	    	JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 4000)", element);//ScrollBy= it will calculate from current position
	    }
//28.method to "scrollTo"
	    public static void scrollTo(WebElement element) {
	    	JavascriptExecutor js=(JavascriptExecutor) driver;
	    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)",element );//ScrollTo: wherever it start, destination is same
	    }
//29. method to "scrollIntoView()"
	    public static void scrollIntoView(WebElement element) {
	    	JavascriptExecutor js=(JavascriptExecutor) driver;
			//WebElement findElement = driver.findElement(By.xpath("//a[text()='Sell on Amazon']"));
			js.executeScript("arguments[0].scrollIntoView();", element);
	    }

//30.method to "Drag and Drop" using Mouse
	    public static void dragAndDrop(WebElement source, WebElement Destination) {
	    	Actions s=new Actions(driver);
			s.dragAndDrop(source, Destination).build().perform();
	    }
//31.method to "wait"
	    public static void Wait() {
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    }
//32. method to Action (Mouse)
	    public static void actionOnElement(WebElement element, String actionName) {
	    	Actions a=new Actions(driver);
	    	if(actionName.equalsIgnoreCase("moveTo")) {
	    		a.moveToElement(element).build().perform();
	    		
	    	}
	    	else if(actionName.equalsIgnoreCase("context click")) {//right click
	    		a.contextClick(element).build().perform();
	    	}
	    	else if(actionName.equalsIgnoreCase("double click")) {
	    		a.doubleClick(element).build().perform();
	    	}
	    	else if(actionName.equalsIgnoreCase("click on")) {
	    		a.click(element).build().perform();
	    	}
	    }

		public static WebDriver driver() {
			// TODO Auto-generated method stub
			return null;
		}

}
