package com.way2automation.APIBatch5.TestCases;

import java.util.HashMap;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.way2automation.APIBatch5.API.UpdateCustomerAPI;
import com.way2automation.APIBatch5.TestSetup.TestSetup;
import com.way2automation.APIBatch5.TestUtils.Data;

import io.restassured.response.Response;

public class ValidateUpdateCustomerAPI extends TestSetup {
	
	@Test(dataProviderClass=Data.class,dataProvider="data")
	public void validateUpdateCustomerAPIWithValidAuthKey(Hashtable<String,String> data)
	{
		testLevelLog.get().assignAuthor("Raman Arora");
		HashMap mapOfField= new HashMap();
		mapOfField.put("name", data.get("name"));
		mapOfField.put("balance", Integer.parseInt(data.get("balance")));
		Response response=UpdateCustomerAPI.sendRequestToUpdateCustomerWithValidAuthKey("cus_FqixbNExSoA4Ff", mapOfField);
		
		
		Assert.assertEquals(response.statusCode(), Integer.parseInt(data.get("expectedStatusCode")));
		
		
	}
	
	

}
