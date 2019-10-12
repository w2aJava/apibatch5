package com.way2automation.APIBatch5.API;

import java.util.Hashtable;

import com.way2automation.APIBatch5.TestSetup.TestSetup;
import com.way2automation.APIBatch5.TestUtils.TestUtil;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CreateCustomerAPI extends TestSetup {

	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data) {
		Response response = given().auth().basic(configProperty.getValidAuthKey(), "").param("email", data.get("email"))
				.param("description", data.get("description")).param("name", data.get("name"))
				.post(configProperty.getCreateCustomerAPIEndPoint());
		// logging reponse in Report
		TestUtil.logResponseInReport(response);
		return response;
	}

	public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String, String> data) {
		Response response = given().auth().basic(configProperty.getInvalidAuthKey(), "")
				.param("email", data.get("email")).param("description", data.get("description"))
				.param("name", data.get("name")).post("customers");
		// logging reponse in Report
		TestUtil.logResponseInReport(response);
		return response;
	}

}
