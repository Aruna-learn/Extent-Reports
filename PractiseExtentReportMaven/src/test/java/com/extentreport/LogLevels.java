package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogLevels {

	public static void main(String[] args) throws IOException {
ExtentReports extentreports=new ExtentReports();//main engine
		
		//ExtentSparkReporter SparkReporter =new ExtentSparkReporter(".\\reports\\extentreport.html");//object reporter and give the path
		
		File file=new File("report.html");
		
		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);//using file instance
		
		extentreports.attachReporter(SparkReporter);//add the main engine to object reporter
		
		extentreports.createTest("test4")//method chaining
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info1")
		.log(Status.PASS, "PASS")
		.log(Status.PASS, "PASS")
		.log(Status.SKIP, "SKIP")
		.log(Status.FAIL, "FAIL")
		.log(Status.WARNING, "WARNING");
		
		
	//	Arrangement of log(it will print the test status based on the below statusm only, 1st check the fail it present test status is  fail otherwise check for the skip status and goes on
		//Fail
		//Skip
		//Warning
		//Pass
		//Info
		
		
		
		
		
		
		
		extentreports.flush();//flush o/p to html file one done coding
		Desktop.getDesktop().browse(new File("report.html").toURI());
		
		
		
		
		
		
	}

}
