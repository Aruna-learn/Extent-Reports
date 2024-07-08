package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ScreenshotattachLogLevel {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		ExtentReports extentreports=new ExtentReports();//main engine


		File file=new File("reports.html");

		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);

		extentreports.attachReporter(SparkReporter);


		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
	String sc=	screenshotbase64();//calling method  
	String path=screenshotfile("flipkart.jpg");//calling method  
	
		//log level screenshots
	    //every  log we have 6 overloaded methods(string, media, markup, string media, throwable, thrwoable and media and thriwable and markup explained in the log different levels class
		
		
		//using media
		extentreports.createTest("loglevel base64media","This is screenshot coding")
		.info(" media")//string
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build())//media
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(sc,"flipkart homepage").build());//media with text
		
		
		//using media with string details text
				extentreports.createTest("loglevel base64media string","This is screenshot coding")
				.info("screnshot")
				.fail("media with string details text",MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build())//media
				.fail("media with string details text",MediaEntityBuilder.createScreenCaptureFromBase64String(sc,"flipkart homepage").build());//media  and string details and we have used flipkart homepage as the title only
				
		Throwable t= new Throwable("this sis throwable exception");
		
		//using throwable and media
				extentreports.createTest("loglevel base64 throwAbLe MEdIa","This is screenshot coding")
				.info(" media")
				.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build())//media
				.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(sc,"flipkart homepage").build());//media with text
		
		
		
		
		
		
		
		
		
		
		
		
		
				//using media
		extentreports.createTest("loglevel pathmedia ","This is screenshot coding")
		.info("media")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())//media
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"flipkart homepage").build());//media with text
		
		//using media with string details text
		extentreports.createTest("loglevel path media string","This is screenshot coding")
		.info("screnshot")
		.fail("media with string details text",MediaEntityBuilder.createScreenCaptureFromPath(path).build())//media
		.fail("media with string details text",MediaEntityBuilder.createScreenCaptureFromPath(path,"flipkart homepage").build());//media with text
		
		////using throwable and media
				extentreports.createTest("loglevel path tHrOwabLe mEdIA","This is screenshot coding")
				.info("media")
				.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path).build())//media
				.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path,"flipkart homepage").build());//media with text
		
		
		
		
		
		
		
		
		
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
