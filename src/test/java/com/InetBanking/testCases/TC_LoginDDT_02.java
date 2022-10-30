package com.InetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;
import com.InetBanking.utilities.XLUtils;

public class TC_LoginDDT_02 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp= new LoginPage(driver);
		
		
		lp.setUserName(user);
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		logger.info("username is provided");
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		lp.setPassword(pwd);
		logger.info("password is provided");
		
		lp.clickSubmit();	
		logger.info(" Submitted ");
		Thread.sleep(2000);
		
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
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
	
	
	
	
	@DataProvider(name="LoginData")
	 String[][] getData() throws IOException {
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/InetBanking/testData/LoginData.xlsx"; 
	
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++) {
			
			for (int j=0; j<colcount; j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
			}
				
		}
		return logindata;
		
	}
	
}
