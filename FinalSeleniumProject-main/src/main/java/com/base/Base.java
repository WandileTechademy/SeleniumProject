package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static String reportPath;
	
	public Base()
	{
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\config\\config.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found "+e.getLocalizedMessage());
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException "+e.getLocalizedMessage());
		}
	}
	public void initializaiton()
	{
		logger=Logger.getLogger(Base.class);
		String browser=prop.getProperty("Browser");
		String url=prop.getProperty("url");
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		logger.info("Application Launched succefully");
	}
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser closed successfully");
	}
	
	public void extentReportSetup()
	{
		reportPath=System.getProperty("user.dir")+"/ExtentReport/index.html";
		reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("TDD Framework Automation");
		reporter.config().setReportName("BigBasket Automation");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester ","Gowri Shankar");
		extent.setSystemInfo("tester ","Gowri Shankar");
		extent.setSystemInfo("tester ","Gowri Shankar");
	}
	
	public void closeExtentReportSetup()
	{
		extent.flush();
	}
	/*
	 * Log4j logging levels :
	 * They are used to categorize entries in log file
	 * 1.ALL
	 * 2.DEBUG
	 * 3.INFO
	 * 4.WARN
	 * 5.ERROR
	 * 6.FATAL
	 */
}
