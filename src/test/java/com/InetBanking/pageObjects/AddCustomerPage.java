package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	public AddCustomerPage (WebDriver rdriver) {
	ldriver=rdriver;
	
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//*[text()='New Customer']")
	@CacheLookup
	WebElement inkAddNewcustomer;
	
	@FindBy(how=How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy (how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How. ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy (how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy (how = How .NAME, using = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy (how = How. NAME,using = "pinno")
	@CacheLookup
	WebElement txtpinno;

	@FindBy (how = How .NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy (how = How. NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy (how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy (how = How. NAME, using="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickAddCustomer() {
		inkAddNewcustomer.click();
	}
	
	public void customerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custDob(String dd,String mm , String yyyy) {
		//txtdob.sendKeys("26-06-1998");
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yyyy);
		
	}
	
	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	public void custPin(String cpin) {
		txtpinno.sendKeys(cpin);
	}
	
	public void custTelePhone(String ctphone) {
		txttelephoneno.sendKeys(ctphone);
	}
	
	public void custEmail(String cemail) {
		txtemailid.sendKeys(cemail);
	}
	
	public void custPassword(String cpassw) {
		txtpassword.sendKeys(cpassw);
	}
	
	public void click_Submit() {
		btnsubmit.click();
	}
}
