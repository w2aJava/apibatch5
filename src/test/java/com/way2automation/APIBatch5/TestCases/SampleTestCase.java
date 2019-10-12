package com.way2automation.APIBatch5.TestCases;

import org.testng.annotations.Test;

import com.way2automation.APIBatch5.TestSetup.TestSetup;

public class SampleTestCase extends TestSetup{

	@Test(groups={"Regression","Sanity"})
	public void validateLogin()
	{
		System.out.println("Validate Login Test Case Executed");
	}
	
	@Test(groups={"Sanity"})
	public void validateSignUp()
	{
		System.out.println("Validate Sign Up Test Case Executed");
	}
	
}
