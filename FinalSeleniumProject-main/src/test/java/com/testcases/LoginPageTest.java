package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pages.DashBoard_Page;
import com.pages.LoginPage;
import com.util.ExcelReader;

import junit.framework.Assert;

public class LoginPageTest extends Base{
	LoginPage lp;
	DashBoard_Page dp;
	@BeforeMethod
	public void launchBrowser()
	{
		initializaiton();
		lp=new LoginPage();
	}
	@AfterMethod
	public void closeSetup()
	{
		tearDown();
	}
	@BeforeTest
	public void reportSetup()
	{
		extentReportSetup();
	}
	@AfterTest
	public void closeReportSetup()
	{
		closeExtentReportSetup();
	}
	@Test
	public void titleTest()
	{
		ExtentTest test = extent.createTest("BigBasket Title Test");
		String actualTitle=lp.getTitle();
		String expectedTitle="Online Grocery Shopping and Online Supermarket in India - bigbasket";
		Assert.assertEquals(actualTitle, expectedTitle);
		test.log(Status.PASS, "Validate Title Test case Passed");
		
	}

	@Test(dataProvider="getData")
	public void validateLoginTest(String userName)
	{
		
		ExtentTest test = extent.createTest("BigBasket Login Test");
		test.log(Status.PASS,"Test started for Email :"+userName);
		dp = lp.validateLogin(userName,test);
		test.log(Status.INFO, "Validate login Test case completed for "+userName);
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][]=null;
		String excelpath=".\\src\\main\\resources\\LoginDetails.xlsx";
		String sheetName="Sheet1";
		ExcelReader reader=new ExcelReader(excelpath,sheetName);
		data=reader.getTestData();
		return data;
	}
	
}
