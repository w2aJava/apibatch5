package com.way2automation.APIBatch5.API;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Set;

import com.way2automation.APIBatch5.TestSetup.TestSetup;
import com.way2automation.APIBatch5.TestUtils.TestUtil;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateCustomerAPI extends TestSetup{
	
	public static Response sendRequestToUpdateCustomerWithValidAuthKey(String customerId,HashMap mapOfFields)
	{
		
		RequestSpecification requestSpecs=given().auth().basic(configProperty.getValidAuthKey(), "");
		if(mapOfFields.size()>0)
		{
			Set<String> keySet=mapOfFields.keySet();
			for(String key:keySet)
			{
				String value=mapOfFields.get(key).toString();
				requestSpecs=requestSpecs.param(key, value);
			}
			
		}
		Response response=requestSpecs.post(configProperty.getUpdateCustomerAPIEndPoint()+"/"+customerId);
		TestUtil.logResponseInReport(response);
		return response;
		
		
		
	}
	
	public static Response sendRequestToUpdateCustomerWithInValidAuthKey(String customerId,HashMap mapOfFields)
	{
		RequestSpecification requestSpecs=given().auth().basic(configProperty.getInvalidAuthKey(), "");
		if(mapOfFields.size()>0)
		{
			Set<String> keySet=mapOfFields.keySet();
			for(String key:keySet)
			{
				String value=mapOfFields.get(key).toString();
				requestSpecs=requestSpecs.param(key, value);
			}
			
		}
		Response response=requestSpecs.post(configProperty.getUpdateCustomerAPIEndPoint()+"/"+customerId);
		TestUtil.logResponseInReport(response);
		return response;
		
	}

}
