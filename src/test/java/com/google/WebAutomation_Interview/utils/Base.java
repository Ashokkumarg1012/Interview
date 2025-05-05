package com.google.WebAutomation_Interview.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Base {
	public WebDriver driver;
	public static Properties prop = new Properties();
	
	@BeforeClass
	public void setup() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//data.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.getProperty("webdriver.chrome.driver","C://chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.getProperty("webdriver.chrome.driver","C://geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
	public int getMonthValue(String month)
	{
		switch(month)
		{
		case "January":
			return 1;
			
		case "February":
			return 2;
		
		case "March":
			return 3;
		
		case "April":
			return 4;
			
		case "May":
			return 5;
		
		case "June":
			return 6;
		
		case "July":
			return 07;
		
		case "August":
			return 8;
		
		case "September":
			return 9;
		
		case "October":
			return 10;
			
		case "November":
			return 11;
			
		case "December":
			return 12;
		
			
		default:
			return 00;
			
		}
	}
	public String getCurrentDate()
	{
		 LocalDate currentDate = LocalDate.now();
		 String date=currentDate.toString();
		 System.out.println("Current date: "+date);
		 String subString = date.substring(date.length()-2);
		 if(subString.charAt(0)=='0')
		 {
			 return date.substring(date.length()-1);
		 }
		 return subString;
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
	public void calendarAction(String date)
	{
		String[] str = date.split("/");
		for(String i:str)
		{
			System.out.println(i+" ");
		}
		
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
