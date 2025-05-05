package com.google.WebAutomation_Interview.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.WebAutomation_Interview.utils.Base;

public class TA_Practice extends Base {
	@Test
	public void launch()
	{
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele = driver.findElement(By.xpath("//p[contains(text(),'Date Picker 1')]"));
		scrollTo(ele);
		driver.findElement(By.xpath("//p[contains(text(),'Date Picker 1')]//child::input")).click();
		driver.findElement(By.xpath("//td[contains(@class,'today')]")).click();
		String selectedDate = driver.findElement(By.xpath("//td[contains(@class,'today')]//child::a")).getText();

		Assert.assertEquals(selectedDate, "4");
	}

}
