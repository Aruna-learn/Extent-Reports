package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttributesAuthorDeviceCategory {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentreports=new ExtentReports();//main engine


		File file=new File("reports.html");

		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);

		extentreports.attachReporter(SparkReporter);


		//Author, device, category
		extentreports.createTest("attributes","additional information")
		.assignAuthor("aruna")
		.assignCategory("smoke")
		.assignDevice("chrome 98")
		.pass("this test is passeed");
		
		
		extentreports.createTest("attributes1","additional information")
		.assignAuthor("chinni")
		.assignCategory("sanity")
		.assignDevice("chrome 99")
		.fail("this test  is failed");
				
		//we can change the order 
		extentreports.createTest("attributes2","additional information")
		.assignCategory("regresswion")
		.assignAuthor("anildsfkji")
		.assignDevice("edhge 99")
		.fail("this test  is failed");
		
		//and no rule to add the 3 author, category and device if we want we can exclude also
		
		extentreports.createTest("attributes3","additional information")
		.assignCategory("regresswion")
		.assignAuthor("anildsfkji")
		.fail("this test  is failed");
		
		//we can add multiple authors, category, devices
		
		extentreports.createTest("attributes4","additional information")
		
		.assignAuthor("chinniredddy")
		.assignAuthor("ammu")
		.assignCategory("regression")
		.assignCategory("smoke")
		.assignDevice("edhge 98")
		.assignDevice("firefox 99")
		.fail("this test  is failed");
		
		//another way to write the multiple authors, category, devices
		
       extentreports.createTest("attributes5","additional information")
		
		.assignAuthor("chinniredddy","chini","madhu", "ammu")
		.assignCategory("regression", "smoke","sanity")
		.assignDevice("chrome99", "edge11", "firefox 99")
		.pass("this test is passed");
	
		
     //another way to write the multiple authors, category, devices using array
		
       extentreports.createTest("attributes6","additional information")
		
		.assignAuthor(new String[]{"redddy","dev","abhi", "shiva"})
		.assignCategory(new String[]{"regression", "smoke","sanity"})
		.assignDevice(new String[]{"firefox99", "edge110", "firefox 95"})
		.pass("this test is passed");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
		
	}

	
}
