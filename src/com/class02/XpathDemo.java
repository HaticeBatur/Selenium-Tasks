package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[2]/input")).sendKeys("VanEarl");
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("VanEarl@&12");
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
	driver.close();
	}
}
