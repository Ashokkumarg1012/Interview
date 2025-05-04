package com.google.WebAutomation_Interview.testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.WebAutomation_Interview.utils.Base;

public class FlipCart extends Base {
	
	@Test(priority=1)
	public void launch() throws InterruptedException
	{
		driver.get("https://www.flipkart.com");
//		driver.findElement(By.xpath("//span[@role='button']")).click();
		//div[contains(text(),'sony')]
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("soundbar ");
		String eleStr="//div[contains(text(),'sony')]";
		explicitWaitClick(eleStr);
//		driver.findElement(By.xpath("//div[contains(text(),'sony')]")).click();
		Thread.sleep(3000);
		
	}
	@Test(priority=2)
	public void filter()
	{
//		String eleStr ="//div[contains(@class,'iToJ4v D')]";
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(eleStr)));
//		WebElement src=driver.findElement(By.xpath("//div[contains(@class,'iToJ4v D')]"));
//		WebElement dest=driver.findElement(By.xpath("//div[@style='transform: translateX(-143.276px);']"));
//		  Actions builder = new Actions(driver);
//         Action draganddrop =  builder.clickAndHold(src).moveToElement(dest).release().build();
//         draganddrop.perform();
		
		WebElement ele = driver.findElement(By.xpath("//div[text()='to']//following::Select[contains(@class,'Gn+jFg')]"));
		scrollTo(ele);
		Select sel=new Select(ele);
		sel.selectByValue("5000");
		
		
		
	}
	@Test(priority=3)
	public void selectItem()
	{
//		driver.findElement(By.xpath("//div[text()='Newest First']")).click();
		String eleStr="//div[text()='Newest First']";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Newest First']")));
		driver.findElement(By.xpath("//div[text()='Newest First']")).click();
		
		
		WebElement ele = driver.findElement(By.xpath("//div[text()='Top Discount of the Sale']//ancestor::div[@class='M4DNwV']"));
		scrollTo(ele);
		hover(ele);
		driver.findElement(By.xpath("//div[text()='Top Discount of the Sale']//ancestor::div[@class='M4DNwV']//following-sibling::div//descendant::span[text()]")).click();
		
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='Top Discount of the Sale']//ancestor::div[@class='M4DNwV']//following-sibling::div//descendant::input"));

//		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'SONY SRS-XB100 Portable Super-Compact,Waterproof')]"));
//		scrollTo(ele);
//		hover(ele);
//		ele.click();
//		driver.findElement(By.xpath("//a[contains(text(),'SONY SRS-XB100 Portable Super-Compact,Waterproof')]//following-sibling::div[@class='PkadOy']//descendant::span[text()='Add to Compare']")).click();
//		WebElement checkbox = driver.findElement(By.xpath("//a[contains(text(),'SONY SRS-XB100 Portable Super-Compact,Waterproof')]//following-sibling::div[@class='PkadOy']//descendant::input[@type='checkbox']"));
		Boolean status=isSelected(checkbox);
		String s=String.valueOf(status);
		Assert.assertEquals(s, "true");

		
	}

}
