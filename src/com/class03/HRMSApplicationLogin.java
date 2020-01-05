package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRMSApplicationLogin {
	public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("VanEarl");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("VanEarl@&12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement logo=driver.findElement(By.xpath("//img[contains(@src,'5acde')]"));
		if(logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("code can not be reached");
		}
	}
}
