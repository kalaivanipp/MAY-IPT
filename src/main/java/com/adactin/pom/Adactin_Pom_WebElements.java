package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Pom_WebElements {

public WebDriver driver;
//public WebDriver getDriver() {
	//return driver;
//}
//public void setDriver(WebDriver driver) {
	//this.driver = driver;
//}
	//Login
	@FindBy(id="username")
	private WebElement username;	
	public WebElement getusername() {
	return username;
	}
	
	@FindBy(id="password")
	
	private WebElement password;	
	public WebElement getpassword() {
	return password;		
	}
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement login;	
    public WebElement getLogin() {
	return login;
	}
	public void setLogin(WebElement login) {
		this.login = login;
	}

	@FindBy(id="location")
	private WebElement location;
	public WebElement getLocation() {
		return location;
	}
		
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotel;
	public WebElement getHotel() {
		return hotel;
	}

	@FindBy(id="room_type")
	private WebElement room;
	public WebElement getRoom() {
		return room;
	}
	
	@FindBy(id="room_nos")
	private WebElement numofroom;
	public WebElement getNumofroom() {
		return numofroom;
	}
	
	@FindBy(id="datepick_in")
	private WebElement checkindate;
	public WebElement getCheckindate() {
		return checkindate;
	}
	
	@ FindBy (xpath="//input[@id='datepick_out']")
	private WebElement checkoutdate;
	public WebElement getCheckoutdate() {
		return checkoutdate;
	}
	
	@FindBy (id="adult_room")
	private WebElement adultroom;
	public WebElement getAdultroom() {
		return adultroom;
	}
	
	@FindBy(id="child_room")
	private WebElement childroom;
	public WebElement getChildroom() {
		return childroom;
	}
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchbutton;
	public WebElement getSearchbutton() {
		return searchbutton;
	}	
	
	@FindBy(xpath="//input[@id='radiobutton_0']")
	private WebElement selradio;
	public WebElement getSelradio() {
		return selradio;
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continu;
	public WebElement getContinu() {
		return continu;
	}
	
	
	//Book A Hotel
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement fname;
	public WebElement getFname() {
		return fname;
	}
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lname;
	public WebElement getLname() {
		return lname;
	}
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	public WebElement getAddress() {
		return address;
	}
	
	@FindBy(xpath="//input[@id='cc_num']")
	private WebElement cardnum;
	public WebElement getCardnum() {
		return cardnum;
	}
	@FindBy(id="cc_type")
	private WebElement cctype;
	public WebElement getCctype() {
		return cctype;
	}
	
	@FindBy(id="cc_exp_month")
	private WebElement cardexpm;

	public WebElement getCardexpm() {
		return cardexpm;
	}

	@FindBy(id="cc_exp_year")	
	private WebElement cardexpy;
	
	public WebElement getCardexpy() {
		return cardexpy;
	}
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	private WebElement cvv;
	public WebElement getCvv() {
		return cvv;
	}
	@FindBy(id="book_now")
	private WebElement booknow;
	public WebElement getBooknow() {
		return booknow;
	}		
	
		public Adactin_Pom_WebElements(WebDriver driver3) {
			this.driver=driver3;
			PageFactory.initElements(driver, this);
			
		}
}
