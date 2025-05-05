
package com.google.WebAutomation_Interview.testScripts;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.WebAutomation_Interview.utils.Base;

public class TA_Practice extends Base {
	@Test(priority=1)
	public void launch()
	{
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele = driver.findElement(By.xpath("//p[contains(text(),'Date Picker 1')]"));
		scrollTo(ele);
		driver.findElement(By.xpath("//p[contains(text(),'Date Picker 1')]//child::input")).click();
		driver.findElement(By.xpath("//td[contains(@class,'today')]")).click();
		String selectedDate = driver.findElement(By.xpath("//td[contains(@class,'today')]//child::a")).getDomAttribute("data-date");
		String actualDay = getCurrentDate();
		Assert.assertEquals(actualDay,selectedDate);
	}
	
//	@Test(priority=2)
	public void dateSelection1_Today()
	{
		String date = prop.getProperty("date");
		calendarAction(date);
	}
	@Test(priority=3)
	public void dateSelection1_day() throws InterruptedException
	{
		String day = prop.getProperty("day");
		driver.findElement(By.xpath("//p[contains(text(),'Date Picker 1')]//child::input")).click();
		Thread.sleep(1000);
		String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
		String month = prop.getProperty("month");
		int monthValue = Integer.parseInt(month);
		int currentMonthValue=getMonthValue(currentMonth);
		int count =monthValue - currentMonthValue;
//		System.out.println("Count: "+count);
		System.out.println("current month: "+currentMonthValue);
		System.out.println("month value: "+monthValue);
		
		String year = prop.getProperty("year");
		int yearValue = Integer.parseInt(year);
		String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		int currentYearValue = Integer.parseInt(currentYear);
		int yearCount = yearValue - currentYearValue;
		
		count = count+ 12*yearCount;
		System.out.println("Count: "+count);
		for(int m=0;m<count;m++)
		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			Thread.sleep(500);
		}
		
		
		
		List<WebElement> Calendar_days = driver.findElements(By.xpath("//a[@class='ui-state-default']")); 
		for(WebElement i:Calendar_days)
		{
			if(i.getDomAttribute("data-date").equalsIgnoreCase(day))
			{
				Thread.sleep(4000);
				i.click();
				break;
			}
		}
		
	}

}
