package com.InetBanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;



public class TC_LoginTest_01 extends BaseClass {



		@Test
		public  void LoginTest() throws InterruptedException, IOException {
			
			driver.get(BaseUrl);
			logger.info("URL Launched");
			Thread.sleep(2000);
			
			LoginPage lp =new LoginPage(driver);
			
			lp.setUserName(userName);
			logger.info("entered username");
			Thread.sleep(2000);

			lp.setPassword(Password);
			logger.info("password entered");
			Thread.sleep(2000);

			
			lp.clickSubmit();
			logger.info("Submited");
			Thread.sleep(2000);

			//System.out.println("Title is :"+ driver.getTitle());
			
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
					{
				Assert.assertTrue(true);
				logger.info("Login Test passed");
					}
			else {
				
				captureScreen(driver,"LoginTest");
				
				Assert.assertTrue(false);
				logger.info("Login Test failed");

			} 
			
			
		}
		
	}
