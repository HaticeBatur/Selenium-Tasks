package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
/*
 * navigate to the hrms
 * enter uid and pwd
 * click on login btn using JSexecutor
 */
public class JSExecutorDemo extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("Hum@nhrm123");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement loginBtn=driver.findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].style.backgroundColor='Red'", loginBtn);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(3000);
		driver.quit();
	}
}
