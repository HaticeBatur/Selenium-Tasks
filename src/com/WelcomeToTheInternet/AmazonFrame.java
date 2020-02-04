package com.WelcomeToTheInternet;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AmazonFrame extends CommonMethods {
/*
 * Amazon  Task 1:
As an analyst, I want to be able to click on an element inside 
any frame displayed on the homepage that will take me to the
respective page. Verify the landing page.
 */
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.amazon.com/");
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Shop Bargain Finds")).click();
		driver.quit();
	}
}
