package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;

public class DashBoard_Page extends Base{

	@FindBy(xpath="//span[text()='BigBasketeer']")
	WebElement custname;
	
	@FindBy(xpath="//button[@type='submit']//parent::div//parent::div//child::input")
	WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchbtn;

	@FindBy(xpath="//section[@id=\"filterbar\"]//child::span[text()='Fruits & Vegetables']")
	WebElement fruitAndVegetables;
	
	@FindBy(xpath="//section[@id=\"filterbar\"]//child::span[text()='Foodgrains, Oil & Masala']")
	WebElement foodGrainsAndOils;
	
	@FindBy(xpath="//*[text()='Clear all']")
	List<WebElement> clearAll;
	
	@FindBy(xpath="//select[@id='sel1']")
	WebElement sortDropDown;
	
	@FindBy(xpath="//i[@class='icon svg-header svg-location svg-location-dim']")
	WebElement changeLocationbtn;
	
	@FindBy(xpath="//span[text()='Chennai']")
	WebElement newLocation;
	public DashBoard_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getText()
	{
		return custname.getText();
	}
	
	public void searchAction(String item,ExtentTest test)
	{
		searchField.sendKeys(item);
		searchbtn.click();
		try {
			Thread.sleep(3000);
			sort(test);
			test.log(Status.INFO, "Sort test completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(fruitAndVegetables));
		fruitAndVegetables.click();
		try
		{
			test.log(Status.PASS,"Test passed for Fruits and Vegetables");
			wait.until(ExpectedConditions.elementToBeClickable(clearAll.get(0)));
			Thread.sleep(5000);
			clearAll.get(0).click();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test Failed for Clear");
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test Failed for Fruits and Vegetables");
		}
		try
		{
			wait.until(ExpectedConditions.visibilityOf(foodGrainsAndOils));
			foodGrainsAndOils.click();
			test.log(Status.PASS,"Test passed for foodGrainsAndOils");
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(clearAll.get(0)));
				Thread.sleep(5000);
				clearAll.get(0).click();
			}
			catch(Exception e)
			{
				test.log(Status.FAIL,"Test Failed for Clear");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test Failed for foodGrainsAndOils");
		}
		
	}
	public void sort(ExtentTest test)
	{
		Select dropdown=new Select(sortDropDown);
		List<WebElement> options = dropdown.getOptions();
		for(int i=0;i<options.size();i++)
		{
			try {
				dropdown.selectByIndex(i);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				test.log(Status.FAIL,"Sort Failed ");
				e.printStackTrace();
			}
			
		}
	}
	public void changeLocation()
	{
		try {
			changeLocationbtn.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div/ul/li[2]/div/div/div[2]/form/div[1]/div/div/span/span[2]/span")).click();
			driver.findElement(By.xpath("//input[@placeholder='Select your city']")).sendKeys("Chennai");
			Thread.sleep(4000);
			newLocation.click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
