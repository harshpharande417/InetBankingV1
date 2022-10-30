package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver lodriver;
public  LoginPage(WebDriver redriver)
{
	lodriver=redriver;
	PageFactory.initElements(redriver, this);
}

@FindBy(name="uid")
@CacheLookup
WebElement txtUserName;


@FindBy(name="password")
@CacheLookup
WebElement txtPassword;


@FindBy(name="btnLogin")
@CacheLookup
WebElement btnLogin;

@FindBy(xpath="//*[text()='Log out']")
@CacheLookup
WebElement logOut;



public void setUserName(String uname) {
	
	txtUserName.sendKeys(uname);
}


public void setPassword(String Pass) {
	
	txtPassword.sendKeys("tyvUbuv");
}

public void clickSubmit () {
	
	btnLogin.click();
}

public void clickLogout () {
	
	logOut.click();
}


}
