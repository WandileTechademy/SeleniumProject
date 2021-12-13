package com.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pages.ViewOffer;
import com.util.ExcelReader;


public class ViewOfferTest extends Base{
	ViewOffer vo;
	@BeforeClass
	public void launchBrowser()
	{
		initializaiton();
		vo = new ViewOffer();
	}
	@AfterClass
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
	public void viewingoffer()
	{
		ExtentTest test = extent.createTest("BigBasket View offers test");
		test.log(Status.INFO, " view offers test started ");
		vo.select(test);
		test.log(Status.INFO, " view offers test ended ");
	}

}
