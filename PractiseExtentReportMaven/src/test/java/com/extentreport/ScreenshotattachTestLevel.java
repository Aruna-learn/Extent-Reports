package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.pwa.model.FileHandlerAccept;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ScreenshotattachTestLevel {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		ExtentReports extentreports=new ExtentReports();//main engine


		File file=new File("reports.html");

		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);

		extentreports.attachReporter(SparkReporter);


		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
	String sc=	screenshotbase64();//calling method  
	String path=screenshotfile("flipkart.jpg");//calling method  
	
		extentreports.createTest("screenshot","This is screenshot coding")
		.info("screnshot");
		
		
		extentreports.createTest("base64 screenshot","This is screenshot coding")
		.info("screnshot")
		.addScreenCaptureFromBase64String(sc);
		
		extentreports.createTest("base64 screenshot with message","This is screenshot coding")
		.info("screnshot")
		.addScreenCaptureFromBase64String(sc,"flipkart image");
		
		//we can add multiple screenshots also
		
		extentreports.createTest("base64 screenshot with message multiple","This is screenshot coding")
		.info("screnshot")
		.addScreenCaptureFromBase64String(sc,"flipkart image")
		.addScreenCaptureFromBase64String(sc,"flipkart image1")
		.addScreenCaptureFromBase64String(sc,"flipkart image2")
		.addScreenCaptureFromBase64String(sc,"flipkart image3")
		.addScreenCaptureFromBase64String(sc,"flipkart image4");
		
		
		
		
		extentreports.createTest("filepath screenshot","This is screenshot coding")
		.info("screnshot")
		.addScreenCaptureFromPath(path);
		

		extentreports.createTest("filepath screenshot with message","This is screenshot coding")
		.info("screnshot")
		.addScreenCaptureFromPath(path,"flipkart image");
		
		//we can add multiple screenshots also
		extentreports.createTest("filepath screenshot with message with multiple","This is screenshot coding")
		.info("screnshot")
		.addScreenCaptureFromPath(path,"flipkart image")
		.addScreenCaptureFromPath(path,"flipkart image1")
		.addScreenCaptureFromPath(path,"flipkart image2")
		.addScreenCaptureFromPath(path,"flipkart image3")
		.addScreenCaptureFromPath(path,"flipkart image4");


		extentreports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}
	public static String  screenshotbase64() {
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;//in webdriver no getscreesnhsot so to get it takescreenshot is using and typecasting
		String base64code=takeScreenshot.getScreenshotAs(OutputType.BASE64);//capturing screenshot in form of base64
		System.out.println("Screenshot saved successfully");

		return base64code;
	}
	public static String  screenshotfile(String fileName ) {
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;//in webdriver no getscreesnhsot so to get it takescreenshot is using and typecasting
		File sourcefile=takeScreenshot.getScreenshotAs(OutputType.FILE);//capturing screenshot in form of file
		File destfile=new File("./Screenshots/"+fileName);//store file in location
		try {
			FileUtils.copyFile(sourcefile, destfile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");

		return destfile.getAbsolutePath();//need path from this method so return the path

	}

	}
