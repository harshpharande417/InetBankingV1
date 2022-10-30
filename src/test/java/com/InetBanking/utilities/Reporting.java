package com.InetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.  HH.mm. ss"). format (new Date ()); //time stamp
		String repName="Test-Report-"+timestamp+".html";
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location
		//sparkReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		//sparkReporter=loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports ();
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "HP");
		
		sparkReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		sparkReporter.config().setReportName("Functional Test Report"); // name of the report 
		//sparkReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		
	
		sparkReporter.config() .setTheme (Theme .DARK);
	}
	public void onTestSuccess (ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		//logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName().ExtentColor.GREEN)); //send the passed information
		
	}

	public void onTestfailure (ITestResult tr) 
	{
	logger=extent.createTest(tr.getName());//create new entry in the report
	
	
	//logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName().Extentcolor.RED));//send the passed information
	
	String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	
	File f = new File(screenshotPath);
	
	if(f.exists())
	{
	try
	{
	logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));
	}
	
	catch(Exception e)
	{
	e.printStackTrace();
	}
	}
}

public void onTestskipped(ITestResult tr)
{
logger=extent.createTest(tr.getName()); // create new entry in th report
//logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),Extentcolor.ORANGE));
}

public void onFinish(ITestContext testContext)
{ 
	extent.flush();

}
	
}
