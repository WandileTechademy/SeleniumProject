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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;

public class OrderItemPage extends Base{
	
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
	
	@FindBy(xpath="//h2[text()='Best Sellers']")
	WebElement bestSellerH2;
	
	@FindBy(xpath="//button[text()='Add ']")
	List<WebElement> productsBestSeller;
	
	@FindBy(xpath="//span[contains(text(),'My ')]")
	WebElement myBasket;
	
	@FindBy(xpath="//button[text()='View Basket & Checkout']")
	WebElement viewOrder;
	
	@FindBy(xpath="//p[text()='CHECKOUT ']")
	WebElement checkoutBtn;
	
	@FindBy(xpath="//button[contains(text(),'Change')]")
	WebElement changeAddr;
	
	@FindBy(xpath="//button[@qa='addAddressCKO']")
	WebElement addAddr;
	
	public OrderItemPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void orderItems(String userName,ExtentTest test)
	{
		signUp.click();
		switchToEmail.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		emailField.sendKeys(userName);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
			test.log(Status.PASS,"Test successfully added Email for "+userName);
			continuebtn.click();
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(verifyOTP));
				verifyOTP.click();
				Thread.sleep(2000);
				//wait.until(ExpectedConditions.elementToBeClickable(productsBestSeller.get(0)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[8]/carousel-product-widget/section/div[2]/div/div[1]/div/div[1]/div/div/product-template-in-container/div[1]/div[4]/div[3]/div/div[5]/div[2]/button")));
				driver.findElement(By.xpath("/html/body/div[1]/div[8]/carousel-product-widget/section/div[2]/div/div[1]/div/div[1]/div/div/product-template-in-container/div[1]/div[4]/div[3]/div/div[5]/div[2]/button")).click();
				//productsBestSeller.get(0).click();
				wait.until(ExpectedConditions.visibilityOf(myBasket));
				Actions obj = new Actions(driver);
				obj.click(myBasket).build().perform();
				wait.until(ExpectedConditions.visibilityOf(viewOrder));
				viewOrder.click();
				checkoutBtn.click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(changeAddr));
				//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loader-background"))));
				changeAddr.click();
				wait.until(ExpectedConditions.elementToBeClickable(addAddr));
				Thread.sleep(5000);
				addAddr.click();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[2]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[2]/div[1]/div/input")).sendKeys("TestingName");
				//surname
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[2]/div[2]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[2]/div[2]/div/input")).sendKeys("TestingSurname");
				//house no.
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[4]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[4]/div[1]/div/input")).sendKeys("34");
				//apartment name
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[4]/div[2]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[4]/div[2]/div/input")).sendKeys("Kayalami Hills");
				//street
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[5]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[5]/div[1]/div/input")).sendKeys("13 First Street");
				//landmark
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[5]/div[2]/div/input")).clear();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[5]/div[2]/div/input")).sendKeys("Opposite Fire Station");

				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[@aria-label = 'Select box activate']")).click();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[6]/div[1]/div/div/input[1]")).sendKeys("Bangalore");
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[6]/div[2]/div/div/div[1]/span")).click();
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[6]/div[2]/div/div/input[1]")).sendKeys("OTC Road");
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div/form/div[9]/div/button[1]")).click();
				Thread.sleep(20000);
				driver.findElement(By.xpath("//button[@qa='confirmSlotBtn']")).click();
				Thread.sleep(10000);
				//select and apply voucher
				driver.findElement(By.xpath("//button[@qa='voucherLinkCKO']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@qa='selVoucher']")).click();
				driver.findElement(By.xpath("//button[@qa='applyVoucher']")).click();
				Thread.sleep(5000);
				test.log(Status.PASS,"Test successfully item");
			}
			catch(Exception e)
			{
				test.log(Status.FAIL,"Test failed ");
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"Test failed for "+userName);
			e.printStackTrace();
		}
	}

}