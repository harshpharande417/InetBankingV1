package com.InetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src =new File("./Configuration/Config.properties");
		
	try {
		FileInputStream fis = new FileInputStream(src);
		
		pro= new Properties();
		pro.load(fis);
	}
	
	catch (Exception e) {
		System.out.println("Exception is :"+e.getMessage());
	}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("BaseUrl");
				return url;
	}
	
	public String getUserName()
	{
		String uname=pro.getProperty("userName");
				return uname;
	}
	
	public String getPassword()
	{
		String pw=pro.getProperty("password");
				return pw;
	}
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
				return chromepath;
	}

	public String getEdgepath()
	{
		String edgepath=pro.getProperty("edgepath");
				return edgepath;
	}
}