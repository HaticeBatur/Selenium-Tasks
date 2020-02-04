package com.WelcomeToTheInternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Task2 extends CommonMethods{
/*
 * ToolsQA
Task 2:
Using the toolsqa Website, write code to accept an 
alert when clicking on 'Alert Box' button and write code that accepts an
alert when clicking on 'Timing Alert' button - DO NOT USE Thread.Sleep();
 */
	public static void main(String[] args) {
		setUp("chrome", "https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		//driver.manage().deleteAllCookies();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//a[@id='cookie_action_close_header']")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[10]/button")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Yes");
		alert.accept();
		driver.quit();
	}
}
