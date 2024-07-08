package com.extentreport;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SystemandEnviromentInfo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
	Capabilities caps= 	((RemoteWebDriver)driver).getCapabilities();

	System.out.println(caps.getBrowserVersion()) ;
	
	System.out.println(caps.getPlatformName()) ;
	
	System.out.println(caps.getBrowserName());
		
		
	
	//get java version suing the system property
	
	System.getProperties().list(System.out);
	System.out.println(System.getProperty("os.name"));
	System.out.println(System.getProperty("java.version"));

		
		

	}

}
