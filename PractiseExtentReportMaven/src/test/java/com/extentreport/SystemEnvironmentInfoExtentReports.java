package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SystemEnvironmentInfoExtentReports {

	public static void main(String[] args) throws IOException {

		
		WebDriver driver=new ChromeDriver();
		
		Capabilities caps= 	((RemoteWebDriver)driver).getCapabilities();
		
		ExtentReports extentreports=new ExtentReports();//main engine


		File file=new File("reports.html");

		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);

		extentreports.attachReporter(SparkReporter);

		
		//logging the environment/system info into extent reports from the  SystemandEnviromentInfo class
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JavaVersion", System.getProperty("java.version"));
		extentreports.setSystemInfo("BrowserVersion", caps.getBrowserVersion());
		extentreports.setSystemInfo("BrowserName", caps.getBrowserName());
		extentreports.setSystemInfo("Platform", caps.getBrowserVersion());
		extentreports.setSystemInfo("Username", "apoololla@gmail.com");
		extentreports.setSystemInfo("password", "aruna1234@");
		extentreports.setSystemInfo("AppURL","https://www.flipkart.com");
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());




	}

}
