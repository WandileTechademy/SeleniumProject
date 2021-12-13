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
import com.pages.LoginPage;
import com.pages.OrderItemPage;
import com.util.ExcelReader;

public class OrderItemTest extends Base{

	OrderItemPage oi;
	@BeforeMethod
	public void launchBrowser()
	{
		initializaiton();
		oi=new OrderItemPage();
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

	@Test(dataProvider="getData")
	public void orderItemsTest(String userName)
	{
		
		ExtentTest test = extent.createTest("BigBasket Login Test");
		test.log(Status.PASS,"Test started for Email :"+userName);
		oi.orderItems(userName,test);
		test.log(Status.INFO, "login Test case completed for "+userName);
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][]=null;
		String excelpath=".\\src\\main\\resources\\LoginDetailsOrder.xlsx";
		String sheetName="Sheet1";
		ExcelReader reader=new ExcelReader(excelpath,sheetName);
		data=reader.getTestData();
		return data;
	}
	
	
}
