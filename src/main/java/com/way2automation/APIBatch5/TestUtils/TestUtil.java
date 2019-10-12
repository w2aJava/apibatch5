package com.way2automation.APIBatch5.TestUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.way2automation.APIBatch5.TestSetup.TestSetup;

import io.restassured.response.Response;

public class TestUtil extends TestSetup{
	
	
	public static boolean checkJsonHasKey(String key,Response response)
	{
		JSONObject json= new JSONObject(response.asString());
		return json.has(key);
	}
	
	
	
	public static void logResponseInReport(Response response)
	{
		testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Click Here To See API Response"
				+ "</font>" + "</b >" + "</summary>" + response.asString() + "</details>"
				+ " \n");
		
		
	}
	
	
public static void archiveTestReport() {
		
		String reportName = "TestReport.html";

		String lastTestReportFilePath = "./src/main+"
				+ "/resources/TestReport/TestReport.html";
		String archiveReportPath = System.getProperty("user.dir")+"/src/test/resources/archievedReport/";

		Date date = new Date();
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String formatedDate = dateFormate.format(date);
		String archiveTestReportName = formatedDate + "_" + reportName;

		File oldReport = new File(lastTestReportFilePath);

		File newFile = new File(archiveReportPath + archiveTestReportName);
		
		System.out.println(oldReport.exists());
		
		if (oldReport.exists()) {
			System.out.println("inside if");
			oldReport.renameTo(newFile);
			oldReport.delete();
		}
	

}
	
	/*public static boolean verifyStatusCode()
	{
		
	}*/

}
