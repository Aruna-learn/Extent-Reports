package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfigurationUsingJSON {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreports=new ExtentReports();//main engine


		File file=new File("reports.html");

		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);

		
		SparkReporter.loadJSONConfig(new File("C:\\JAVA_PRACTISE\\Git_Practise\\PractiseExtentReportMaven\\src\\test\\resources\\extentreport-config.json"));
		
		
		extentreports.attachReporter(SparkReporter);

		//We have to apply configuration for the extent report using spark reporter object onlyy because for every thing we can fdifferent configurations and beautiful and if we use the extenreporter object we get 1 kind of confuguration only
		
		//i have get the json file from github and done configuration change as per my requirement 
		//so i have to load the json file in sparkreporter to update the change to spark reporter
		
		
		
		
		extentreports.createTest("Configuration json","Configuration information")
		.assignAuthor("roopa")
		.assignCategory("smokee")
		.assignDevice("chrome 98")
		.pass("this test is passeed");
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}
