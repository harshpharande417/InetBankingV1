package com.InetBanking.testCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.AddCustomerPage;
import com.InetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_03 extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		lp.setUserName(userName);
		Thread.sleep(2000);
		logger.info("Username provided");
		
		lp.setPassword(Password);
		Thread.sleep(2000);
		logger.info("Password provided");
		
		lp.clickSubmit();
		Thread.sleep(2000);
		logger.info("submitted");
		
		//Thread.sleep(2000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddCustomer();
		logger.info("clicked on AddNewCustomer once");
		Thread.sleep(2000);
		
	 driver.navigate().back();
	 logger.info("taken back");
	 Thread.sleep(2000);
	 
	 addcust.clickAddCustomer();
		logger.info("clicked on AddNewCustomer 2nd time");
		Thread.sleep(2000);
		
		/* Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Size of cookies:"+cookies.size());
		
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+":"+cookie.getValue());
		}
		driver.manage().deleteAllCookies();
		Thread.sleep(2000); /*
		
		//driver.findElement(By.xpath("//*[@aria-label='Close ad']")).click();
		
		//driver.findElement(By.xpath("//span[text()='Close']")).click();
		//span[text()='Close']
		//logger.info("Add captured and closed");
		//*[@aria-label='Close ad']
		//*[@id="dismiss-button"]
	
		*/
		
		
		addcust.customerName("Harshad");
		logger.info("entered name");
		addcust.custGender("M");
		Thread.sleep(2000);
		logger.info("selected gender");
		addcust.custDob("26", "06", "1998");
		logger.info("provided dob");
		
		Thread.sleep(2000);
		
		addcust.custAddress("Warje ABC");
		logger.info("adress entered");
		addcust.custCity("Pune");
		logger.info("entered city");
		addcust.custState("Maharashtra");
		logger.info("entered state");
		addcust.custPin("412003");
		logger.info("entered pin");
		addcust.custTelePhone("9527528521");
		logger.info("phone number given");
		
		String email=randomstring()+"@gmail.com";
		addcust.custEmail(email);
		logger.info("provided email");
	
		addcust.custPassword("abc123");
		addcust.click_Submit();
		logger.info("entered pwd");
	
		Thread.sleep(2000);
		
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true) {
		Assert.assertTrue(true);
	}
	else {
		
		captureScreen(driver,"AddNewCustomer");
		Assert.assertTrue(false);
	}
	
	}

	
	//*[text()='Continue']
	public String randomstring() {
		String genaratestring =RandomStringUtils.randomAlphabetic(6);
		return genaratestring;
		
	}
	
public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		
		catch (Exception e){
			
			return false;
			
		}
	}
}
