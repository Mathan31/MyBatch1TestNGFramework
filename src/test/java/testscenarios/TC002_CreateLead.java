package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC002_CreateLead extends BaseClass{
	
	@BeforeTest
	public void setupTest() {
		excelFileName = "TC02";
		authors = "Logitha";
		category = "Sanity";
		testName = "Salesforce Create Lead";
		testDescription = "Validate all the mandatory fields and create a lead by providing only mandatory fields";
		testModule = "Create Lead";
	}
	
	@Test(priority = 1,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String userName,String password) {
		boolean result = new LoginPage(driver,node) 
		.enterUserName(userName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(FakerDataFactory.getLastName())
		.enterCompanyName(FakerDataFactory.getCompanyName())
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		
		Assert.assertTrue(result);
	}

}
