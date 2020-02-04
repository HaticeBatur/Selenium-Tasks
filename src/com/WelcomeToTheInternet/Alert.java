package com.WelcomeToTheInternet;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class Alert extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='alert")).click();
		Thread.sleep(3000);
		acceptAlert();
	}
}
