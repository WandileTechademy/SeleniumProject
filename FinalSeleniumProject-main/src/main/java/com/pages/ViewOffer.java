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


public class ViewOffer extends Base {
	@FindBy(xpath="//span[text() ='OFFERS']")
	WebElement offersIcon;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/product-deck/section/div[2]/div[4]/div[1]/div/div/div[2]/div/div[1]/product-template/div/div[4]/div[3]/div/div[3]/div[2]/div[1]/div/input")
	WebElement onionField;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/product-deck/section/div[2]/div[4]/div[1]/div/div/div[2]/div/div[1]/product-template/div/div[4]/div[3]/div/div[3]/div[2]/div[2]/button")
	WebElement onionTocart;
	
	public ViewOffer()
	{
		PageFactory.initElements(driver, this);
	}
	public void select(ExtentTest test)
	{
		offersIcon.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(onionField));
		onionField.sendKeys("1");
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(onionTocart));
			test.log(Status.PASS,"Test successful for onions ");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test failed for onions");
		}
		
		try {
			
			onionTocart.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
