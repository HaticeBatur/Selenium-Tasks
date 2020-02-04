package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

/*
 * navigate to google search for specific item
 */
public class RecapAction extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://google.com/");
		driver.findElement(By.name("q")).sendKeys("iPhone 11 pro");
		
		Actions act=new Actions(driver);
		//identify an element
		WebElement button=driver.findElement(By.name("btnK"));
		//1. way
		//act.moveToElement(button).click().perform();
		//2. way
		act.click(button).perform();
		Thread.sleep(5000);
		driver.quit();
	}
}
