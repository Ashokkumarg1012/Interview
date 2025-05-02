package com.google.WebAutomation_Interview.testBase;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

	
	
//	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
