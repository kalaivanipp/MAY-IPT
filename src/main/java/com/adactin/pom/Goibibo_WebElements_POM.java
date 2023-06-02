package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Goibibo_WebElements_POM {
	
	public static WebDriver driver;
	public WebDriver getDriver1() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//input[@id='Billing Address']")
	private WebElement billAddress;
	
	@FindBy(xpath="//input[@id='Pincode']")
	private WebElement pinCode;
	
	@FindBy(xpath="//ul[@class='sc-uVWWZ cszMtI']")
	private WebElement state;
	
	@FindBy(xpath="//input[@id='confirm_check']")
	private WebElement confirm;
	
	@FindBy(xpath="//select[@class='common-elementsstyles__CustSelectTrvl-sc-ilw4bs-9 lpjPee']")
	private WebElement TitleMr;
	
	@FindBy(xpath="//input[@name='givenname']")
	private WebElement fname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lname;
	
	@FindBy(xpath="//input[@id='//span[text()='Adult 2']']")
	private WebElement Adult2;
	
	@FindBy(xpath="//input[@id='//span[text()='Adult 3']']")
	private WebElement Adult3;
	
	@FindBy(xpath="//input[@id='//span[text()='Adult 4']']")
	private WebElement Adult4;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceed;
	
	

	public WebElement getBillAddress() {
		return billAddress;
	}



	public void setBillAddress(WebElement billAddress) {
		this.billAddress = billAddress;
	}



	public WebElement getPinCode() {
		return pinCode;
	}



	public void setPinCode(WebElement pinCode) {
		this.pinCode = pinCode;
	}



	public WebElement getState() {
		return state;
	}



	public void setState(WebElement state) {
		this.state = state;
	}



	public WebElement getConfirm() {
		return confirm;
	}



	public void setConfirm(WebElement confirm) {
		this.confirm = confirm;
	}



	public WebElement getTitleMr() {
		return TitleMr;
	}



	public void setTitleMr(WebElement titleMr) {
		TitleMr = titleMr;
	}



	public WebElement getFname() {
		return fname;
	}



	public void setFname(WebElement fname) {
		this.fname = fname;
	}



	public WebElement getLname() {
		return lname;
	}



	public void setLname(WebElement lname) {
		this.lname = lname;
	}



	public WebElement getAdult2() {
		return Adult2;
	}



	public void setAdult2(WebElement adult2) {
		Adult2 = adult2;
	}



	public WebElement getAdult3() {
		return Adult3;
	}



	public void setAdult3(WebElement adult3) {
		Adult3 = adult3;
	}



	public WebElement getAdult4() {
		return Adult4;
	}



	public void setAdult4(WebElement adult4) {
		Adult4 = adult4;
	}



	public WebElement getEmail() {
		return email;
	}



	public void setEmail(WebElement email) {
		this.email = email;
	}



	public WebElement getProceed() {
		return proceed;
	}



	public void setProceed(WebElement proceed) {
		this.proceed = proceed;
	}



	public static WebDriver getDriver() {
		return driver;
	}



	public Goibibo_WebElements_POM(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1, this);

	}

}