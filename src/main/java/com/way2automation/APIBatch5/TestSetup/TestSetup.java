package com.way2automation.APIBatch5.TestSetup;

import java.io.IOException;
import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.way2automation.APIBatch5.TestUtils.ConfigProperties;
import com.way2automation.APIBatch5.TestUtils.ExcelReader;
import com.way2automation.APIBatch5.TestUtils.Extentmanager;
import com.way2automation.APIBatch5.TestUtils.TestUtil;


import io.restassured.RestAssured;

public class TestSetup {

	public static ConfigProperties configProperty;
	public static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> classLevelLog=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLog=new ThreadLocal<ExtentTest>();

	public static ExcelReader excel = new ExcelReader("./src/test/resources/testData/TestDataSheet.xlsx");

	@BeforeSuite
	public void setUpFramework() throws IOException {
		/*
		 * Properties prop = new Properties(); FileInputStream fis = new
		 * FileInputStream(
		 * "D:\\Workspace\\API_Batch5_RestAssured\\src\\test\\resources\\propertyFiles\\config.properties"
		 * ); prop.load(fis);
		 */
		configProperty = ConfigFactory.create(ConfigProperties.class);

		/*
		 * RestAssured.baseURI = prop.getProperty("baseURI");
		 * RestAssured.basePath = prop.getProperty("basePath");
		 */

		TestUtil.archiveTestReport();
		RestAssured.baseURI = configProperty.getBaseURI();
		RestAssured.basePath = configProperty.getBasePath();
		extentReport = Extentmanager
				.GetExtent("./src/main/resources/TestReport/TestReport.html");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test executed");
	}

	@BeforeClass
	public synchronized void beforeClass() {
		System.out.println("before Class executed");
		ExtentTest test= extentReport.createTest(getClass().getSimpleName());
		classLevelLog.set(test);
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("Execution of Test Case:- " + method.getName() + " started");
		
		
	}

	@AfterMethod
	public void afterMethod(ITestResult testCaseResult) {
		System.out.println("Execution of Test Case:- " + testCaseResult.getName() + " finished");
		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after Class executed");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after Test executed");
	}

	@AfterSuite
	public void tearDownFramework() throws Exception  {
		System.out.println("after Suite executed");
		extentReport.flush();
		
		//ZipAndSendMail.sendMail();

	}

}
