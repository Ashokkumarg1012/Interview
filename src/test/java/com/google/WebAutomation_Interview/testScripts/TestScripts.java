package com.google.WebAutomation_Interview.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.WebAutomation_Interview.utils.Base;

public class TestScripts extends Base {
	@Test(priority=1)
	public void searchItem() throws InterruptedException
	{
		driver.get("https://www.duckduckgo.com");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iPhone 15");
		driver.findElement(By.xpath("//button[@class='iconButton_button__A_Uiu searchbox_searchButton__LxebD']")).click();
		String deviceName=driver.findElement(By.xpath("//a[@data-testid='about_official-website']")).getText();
		Boolean result=false;
		if(deviceName.contains("apple.com"))
		{
			result=true;
		}
//		Assert.assertTrue(result,"It is a official website");
		Assert.assertTrue(result, "It is not a official website");
		Thread.sleep(2000);
	
		
		
		
		
	}
	@Test(priority=2)
	public void image() 
	{
		WebElement ele = driver.findElement(By.xpath("(//a[@class='kFFXe30DOpq5j1hbWU1q wZ4JdaHxSAhGy1HoNVja d26Geqs1C__RaCO7MUs2'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
		
		driver.findElement(By.xpath("//a[text()='Images']")).click();
		Boolean selected = driver.findElement(By.cssSelector("a.kFFXe30DOpq5j1hbWU1q SnptgjT2zdOhGYfNng6g wZ4JdaHxSAhGy1HoNVja d26Geqs1C__RaCO7MUs2: :after")).isSelected();
		
		Assert.assertTrue(selected, "image is selected");
	}
}
