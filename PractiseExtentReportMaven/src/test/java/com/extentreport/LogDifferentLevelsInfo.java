package com.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogDifferentLevelsInfo {

	public static void main(String[] args) throws IOException {
ExtentReports extentreports=new ExtentReports();//main engine
		
		
		File file=new File("reports.html");
		
		ExtentSparkReporter SparkReporter =new ExtentSparkReporter(file);
		
		extentreports.attachReporter(SparkReporter);
		
		
		//different types of log information
		//1.Text-bold/italic
		extentreports.createTest("test5")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "<b>info1</b>")
		.log(Status.INFO, "<i>info1</i>")
		.log(Status.INFO, "<b><i>info1</i></b>");

  
		
	//2.Xml
		
		String xmldata="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		
		
		String jsondata="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		
		extentreports.createTest("XML data")
		.log(Status.INFO,MarkupHelper.createCodeBlock(xmldata, CodeLanguage.XML));
		
		
		
		extentreports.createTest("JSON data")
		.info(MarkupHelper.createCodeBlock(jsondata, CodeLanguage.JSON));
		
		//3. collection data(list, set, map)
		//list
		List<String> listdata=new ArrayList<String>();
		listdata.add("aruna");
		listdata.add("chinni");
		listdata.add("poori");
		listdata.add("madhu");


		Map<Integer,String> mapdata=new HashMap<Integer, String>();
		mapdata.put(101, "aruna");
		mapdata.put(103, "chinii");
		mapdata.put(80, "akka");
		mapdata.put(1567, "pooti");

		Set<Integer> setdata=mapdata.keySet();
		
		extentreports.createTest("List set data")
		.info(MarkupHelper.createOrderedList(listdata))
		.info(MarkupHelper.createUnorderedList(listdata));

		
		extentreports.createTest("Map data")
		.info(MarkupHelper.createOrderedList(mapdata))
		.info(MarkupHelper.createUnorderedList(mapdata));
		
		
		extentreports.createTest("Set data")
		.info(MarkupHelper.createOrderedList(setdata))
		.info(MarkupHelper.createUnorderedList(setdata));
		
		//Highlight any message
		extentreports.createTest("Highlight data/message")
		.info("this is highlighted")
		.info(MarkupHelper.createLabel("Aruna reddy", ExtentColor.YELLOW));
		
		
		
		//Exceptions
		//we ncan do in 2ways 
		//1 using try catch block
		try {
			int i=5/0;
		} catch (Exception e) {
			extentreports.createTest("exception trycatch")
			.fail(e);
			
			
		}
		
		//2 using exxception super class throwable
		
		Throwable t=new RuntimeException("Runtimeexception");
				extentreports.createTest("exception runtitme")
				.fail(t);
		
		
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());
		
		
		
		
		
		
	}

}
