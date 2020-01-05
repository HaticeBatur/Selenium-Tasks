package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	/*
	 * TC 2: Mercury Tours Registration: Open chrome browser Go to “http://newtours.demoaut.com/”
	 * Click on Register Link Fill out all required info
	 * Click Submit User successfully registered
	 * (Create 2 scripts using different locators)
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Anna");
		driver.findElement(By.name("lastName")).sendKeys("Maria");
		driver.findElement(By.name("phone")).sendKeys("2348764565");
		driver.findElement(By.name("userName")).sendKeys("abc.hanna@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12343456");
		driver.findElement(By.name("confirmPassword")).sendKeys("12343456");
		driver.findElement(By.name("register")).click();
	}
}
