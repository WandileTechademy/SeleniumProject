package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;

public class LoginPage extends Base{

	@FindBy(linkText="Login/Sign Up")
	WebElement signUp;
	
	@FindBy(xpath="//button[text()='Login using Email Address']")
	WebElement switchToEmail;
	
	@FindBy(id="otpEmail")
	WebElement emailField;
	
	@FindBy(xpath="//button[text()='Login using Mobile Number']//following-sibling::button[text()='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//button[contains(text(),'Verify & Continue')]")
	WebElement verifyOTP;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public DashBoard_Page validateLogin(String userName,ExtentTest test)
	{
		signUp.click();
		switchToEmail.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		emailField.sendKeys(userName);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
			test.log(Status.PASS,"Test successfully added Email for "+userName);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test failed for "+userName);
		}
		continuebtn.click();
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(verifyOTP));
			verifyOTP.click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test failed Verify OTP unavailable ");
		}
		return new DashBoard_Page();
	}
}
