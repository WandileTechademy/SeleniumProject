package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;

public class DOWPage extends Base{

	@FindBy(xpath="//select[@id='sel1']")
	WebElement sortDropDown;
	@FindBy(xpath="//img[@src='//www.bigbasket.com/media/uploads/banner_images/hp_button_m_09_60_250921.png']")
	WebElement dowIcon;
	public DOWPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sort(ExtentTest test)
	{
		dowIcon.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(sortDropDown));
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
}
