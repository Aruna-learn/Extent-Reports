package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {

	public static void main(String[] args) throws IOException {
		ExtentReports extentreports=new ExtentReports();//main engine
		
		//ExtentSparkReporter SparkReporter =new ExtentSparkReporter(".\\reports\\extentreport.html");//object reporter and give the path
		
		File file=new File(".\\reports\\extentreport.html");
		
		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);//using file instance
		
		
		extentreports.attachReporter(SparkReporter);//add the main engine to object reporter
		
		extentreports.createTest("test1")
		.pass("This is passed");//method chaining
		
		
		
		//or
		ExtentTest test2	=extentreports.createTest("test2");
		test2.fail("This is failed");
		
		ExtentTest test3	=extentreports.createTest("test3");
		test3.log(Status.SKIP, "This is skipped");
		
		
		
		
		extentreports.flush();//flush o/p to html file one done coding
		Desktop.getDesktop().browse(new File("extentreport.html").toURI());
		
		

	}

}
