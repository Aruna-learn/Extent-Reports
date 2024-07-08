package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateMultipleReportsBasedOnStatus {

	public static void main(String[] args) throws IOException {

		ExtentReports extentreports=new ExtentReports();//main engine

		ExtentSparkReporter SparkReporter =new ExtentSparkReporter("AllTests.html");//alltests

		
		ExtentSparkReporter SparkReporter_fail =new ExtentSparkReporter("FailTests.html");//fail tests 
		SparkReporter_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();//filter fail tests

		

		ExtentSparkReporter SparkReporter_SkipWarning =new ExtentSparkReporter("SkipandWarningTests.html");
		SparkReporter_SkipWarning.filter().statusFilter().as(new Status[] {Status.SKIP,Status.WARNING}).apply();//filterskipand warnign tests

		

		ExtentSparkReporter SparkReporter_pass =new ExtentSparkReporter("passTests.html");
		SparkReporter_pass.filter().statusFilter().as(new Status[] {Status.PASS}).apply();//filterpass tests


		
		ExtentSparkReporter SparkReporter_info =new ExtentSparkReporter("InfoTests.html");
		SparkReporter_info.filter().statusFilter().as(new Status[] {Status.INFO}).apply();//filter info tests



		extentreports.attachReporter(SparkReporter,SparkReporter_fail,SparkReporter_SkipWarning,SparkReporter_pass,SparkReporter_info);

		
		//Author, device, category
		extentreports.createTest("passtest","additional information")
		.assignAuthor("aruna")
		.assignCategory("smoke")
		.assignDevice("chrome 98")
		.pass("this test is passeed");


		extentreports.createTest("failtest","additional information")
		.assignAuthor("chinni")
		.assignCategory("sanity")
		.assignDevice("chrome 99")
		.fail("this test  is failed");

		extentreports.createTest("skiptest","additional information")
		.assignCategory("regresswion")
		.assignAuthor("anildsfkji")
		.assignDevice("edhge 99")
		.skip("skipped");



		extentreports.createTest("warningtest","additional information")
		.assignCategory("regresswion")
		.assignAuthor("anildsfkji")
		.warning("warning test details");



		extentreports.createTest("info","additional information")
		.info("this is information reports")
		.assignAuthor("chinniredddy")
		.assignAuthor("ammu")
		.assignCategory("regression")
		.assignCategory("smoke")
		.assignDevice("edhge 98")
		.assignDevice("firefox 99");
		






		Throwable t=new RuntimeException("Runtimeexception");
		extentreports.createTest("exception runtitme")
		.fail(t);


















		extentreports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailTests.html").toURI());
		Desktop.getDesktop().browse(new File("SkipandWarningTests.html").toURI());
		Desktop.getDesktop().browse(new File("passTests.html").toURI());
		Desktop.getDesktop().browse(new File("infoTests.html").toURI());
		
		
		
		
		
		
		
		

	}

	private static ExtentTest assignAuthor(String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
