package com.google.WebAutomation_Interview.utils;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Base {
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.getProperty("webdriver.chrome.driver","C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
	public void scrollTo(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
	public void takeScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//img.png");
		FileUtils.copyFile(src, dest);		
		
	}
	public void explicitWaitClick(String eleStr)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(eleStr)));
		driver.findElement(By.xpath(eleStr)).click();
		
	}
	
	


	public void isDisplayed(WebElement ele)
	{
		if(ele.isDisplayed())
		{
			System.out.println("Element is visible");
		}
		else
			System.out.println("Element is not visible");
	}

	public void hover(WebElement ele)
	{
		Actions a=new Actions(driver);
		
		a.moveToElement(ele).perform();
	}
	
	public Boolean isSelected(WebElement ele)
	{
		if(ele.isSelected())
		{
			return true;
		}
		else
			return false;
	}

	
	
//	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
