package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookCreateAccount {
	/* Using Xpath ONLY TC 1: Facebook login: 
	Open chrome browser
	Go to “https://www.facebook.com/”
	Enter valid username and valid password and click login 
	User successfully logged in
	*/
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Anna");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Maria");
		driver.findElement(By.xpath("//input[@id='u_0_k']")).sendKeys("630 998 1234");
		driver.findElement(By.xpath("//input[@id='u_0_p']")).sendKeys("5674332");
		driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("10");
		driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("8");
		driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("1980");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='u_0_a']")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		Thread.sleep(5000);
		driver.close();
	}
}
