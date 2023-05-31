package com.adactin.stepdefinition;
import org.openqa.selenium.WebDriver;
import com.adactin.baseclass.BaseClass;
import com.adactin.helper.File_Reader_Manager;
import com.adactin.pom.Adactin_Pom_WebElements;
import com.adactin.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	public static WebDriver driver=TestRunner.driver;	
	public static Adactin_Pom_WebElements p=new Adactin_Pom_WebElements(driver);//object created to POM WebElement Class i.e. src/main/java
	
	//Login Page
	@Given("Open Chrome and launch Browser")
	public void open_chrome_and_launch_browser() throws Throwable {
		//String urlname=File_Reader_Manager.getInstance().getInstanceCR().url();
		//url(urlname);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	//url("https://adactinhotelapp.com/");  //this is for cucumber BDD
	    	}
	@When("user enters username in text field")
	public void user_enters_username_in_text_field() {
		tosendKeys(p.getusername(),"KalaivaniGreens");
	}
	@When("user enters password in textfield")
	public void user_enters_password_in_textfield() {
	    tosendKeys(p.getpassword(),"Kalai@Adactin");
	}
	@Then("user can succeffully enter into Homepage")
	public void user_can_succeffully_enter_into_homepage() {
	    p.getLogin().click();
	}
	
	//Search Hotel
	@Given("user selects Location")
	public void user_selects_location() {
		Drop_DownBox(p.getLocation(),"index","2");  
	}
	@When("user selects the Hotel")
	public void user_selects_the_hotel() {
		Drop_DownBox(p.getHotel(),"index","2"); 
	}
	@When("user selects Room Type")
	public void user_selects_room_type() {
		Drop_DownBox(p.getRoom(),"value","Double");
	}
	@When("user selects NumofRooms")
	public void user_selects_numof_rooms() {
		Drop_DownBox(p.getNumofroom(),"text","2 - Two"); 
	}
	@When("user enters Checkin & Checkout Date")
	public void user_enters_checkin_checkout_date() {
		p.getCheckindate().click();
		p.getCheckindate().clear();
		tosendKeys(p.getCheckindate(),"12/10/2022");
		p.getCheckindate().click();
		p.getCheckoutdate().clear();
		tosendKeys(p.getCheckoutdate(),"22/10/2022");          
	}
	@When("user selects AdultsperRoom")
	public void user_selects_adultsper_room() {
		Drop_DownBox(p.getAdultroom(), "text","3 - Three"); 
	}
	@When("user selects ChildrenperRoom")
	public void user_selects_childrenper_room() {
		Drop_DownBox(p.getChildroom(), "text","4 - Four");
	}
	@When("user clicks searchButton to serach Hotel")
	public void user_clicks_search_button_to_serach_hotel() {
		p.getSearchbutton().click();        
	}
	@Then("user clicks contiune to Book the Hotel")
	public void user_clicks_contiune_to_book_the_hotel() {
		 p.getSelradio().click();
	        p.getContinu().click(); 
	}



}
