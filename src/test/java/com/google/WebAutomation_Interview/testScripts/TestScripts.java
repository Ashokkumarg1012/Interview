package com.google.WebAutomation_Interview.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.WebAutomation_Interview.testBase.Base;

public class TestScripts extends Base {
	@Test
	public void searchItem()
	{
//		driver.get("https://www.amazon.in/");
//		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("soundbar with woofer jbl");
//		driver.findElement(By.xpath("//div[@aria-label='soundbar with woofer jbl']")).click();
//		
//		WebElement ele=driver.findElement(By.xpath("//span[text()='JBL']//preceding-sibling::div"));
//		scrollTo(ele);
//		driver.findElement(By.xpath("//span[text()='JBL']//preceding-sibling::div")).click();
//		scrollTo(ele);
//		Boolean selectBrandCheckbox = driver.findElement(By.xpath("//span[text()='JBL']//preceding-sibling::div")).isSelected();
//		Assert.assertTrue(selectBrandCheckbox, "Brand name is not selected");
//		WebElement item = driver.findElement(By.xpath("//span[contains(text(),' JBL Newly Launched Cinema SB560, Dolby Audio Soundbar with Wireless Subwoofer for Extra Deep Bass, 3.1 Channel, Center Channel for Superior Voice Clarity, HDMI eARC, Bluetooth Connectivity (250W)')]"));
//		scrollTo(item);
//		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("berry");
		driver.findElement(By.xpath("//h4[contains(text(),'Strawberry')]//ancestor::div[@class='product']//descendant::a[@class='increment']")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'Strawberry')]//ancestor::div[@class='product']//descendant::a[@class='increment']")).click();

		
		
		
		
		
	}
	//span[contains(text(),' Cinema SB180, Wireless Subwoofer for Extra Deep Bass, 2.1 Channel Home Theatre with Remote, HDMI ARC, Bluetooth & Optical Connectivity (220W)')]//ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//descendant::button
	
	@Test
	public void addToCart()
	{
//		driver.findElement(By.xpath("//span[contains(text(),' Cinema SB180, Wireless Subwoofer for Extra Deep Bass, 2.1 Channel Home Theatre with Remote, HDMI ARC, Bluetooth & Optical Connectivity (220W)')]//ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//descendant::button")).click();

		driver.findElement(By.xpath("//h4[contains(text(),'Strawberry')]//ancestor::div[@class='product']//descendant::div[@class='product-action']")).click();
		String buttonText = driver.findElement(By.xpath("//h4[contains(text(),'Strawberry')]//ancestor::div[@class='product']//descendant::button")).getDomAttribute("text");
		Boolean addToCart=false;
		if(buttonText.contains("Added"))
		{
			addToCart =true;
		}
		Assert.assertTrue(addToCart, "Add to cart is failed");
	}

}
