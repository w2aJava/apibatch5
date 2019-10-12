package com.way2automation.APIBatch5.TestUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	"file:src/test/resources/propertyFiles/config.properties"
})
public interface ConfigProperties extends Config {
	
	@Key("baseURI")
	public String getBaseURI();
	
	@Key("basePath")
	public String getBasePath();
	
	@Key("createCustomerAPIEndPoint")
	public String getCreateCustomerAPIEndPoint();
	
	@Key("age")
	public int getAge();
	
	@Key("balanceAmount")
	public double getBalanaceAmount();
	
	@Key("testFlag")
	public boolean getTestFlag();
	
	@Key("testDataSheetName")
	public String getTestDataSheetName();
	
	@Key("updateCustomerAPIEndPoint")
	public String getUpdateCustomerAPIEndPoint();
	
	@Key("deleteCustomerAPIEndpoint")
	public String getDeleteCustomerAPIEndPoint();
	
	@Key("validAuthKey")
	public String getValidAuthKey();
	
	@Key("invalidAuthKey")
	public String getInvalidAuthKey();
	
	@Key("reportPath")
	public String getReportFolderPath();
}
