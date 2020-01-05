package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginPage {
	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://facebook.com/");
	driver.findElement(By.id("email")).sendKeys("haticebatur_@hotmail.com");
	driver.findElement(By.id("pass")).sendKeys("hatcem83");
	driver.findElement(By.id("u_0_2")).click();
	driver.close();
	
	}
}
