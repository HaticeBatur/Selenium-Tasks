package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[2]/input")).sendKeys("VanEarl");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[3]/input")).sendKeys("VanEarl@&12");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[5]/input")).click();
		
//		driver.findElement(By.id("txtUserName")).sendKeys("admin");
//		Thread.sleep(3000);
//		driver.findElement(By.id("txtPassword")).sendKeys("@gmail.com");
//		Thread.sleep(3000);
//		driver.findElement(By.id("btnLogin")).click();
//		Thread.sleep(3000);
	}
}
