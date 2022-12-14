package com.InetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rconfig=new ReadConfig();
	
	
	public String BaseUrl=rconfig.getApplicationURL();
	public String userName=rconfig.getUserName();
	public String Password=rconfig.getPassword();
	public static WebDriver driver; 
	
	public static Logger logger;
	
	@BeforeClass
	public  void Setup() {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	
		System.setProperty("webdriver.chrome.driver",rconfig.getChromepath());
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(BaseUrl);
		
	}
		
		
	@AfterClass
	public  void tearDown() {
		
		driver.quit();
	}
	
	
		public void captureScreen (WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs (OutputType .FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		
	}
}
